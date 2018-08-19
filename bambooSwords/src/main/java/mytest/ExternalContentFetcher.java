package mytest;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;

public class ExternalContentFetcher {
    private static final String
            FETCH_USER_AGENT_VALUE =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";

    public static final int DEFAULT_FETCH_DATA_TIMEOUT_SECONDS = 5;
    private static final int DEFAULT_FETCH_DATA_SIZE_LIMIT = 1024 * 1024;  //2M

    private static final int CREATIVE_VIDEO_FETCH_DATA_TIMEOUT_SECONDS = 30;  //30 seconds
    private static final int CREATIVE_VIDEO_FETCH_DATA_SIZE_LIMIT = 1024 * 1024 * 300;  //300M

    private static final int CREATIVE_IMAGE_FETCH_DATA_TIMEOUT_SECONDS = 10;  //10 seconds
    private static final int CREATIVE_IMAGE_FETCH_DATA_SIZE_LIMIT = 1024 * 1024 * 5;  //5M

    private static final int CREATIVE_VAST_FETCH_DATA_TIMEOUT_SECONDS = DEFAULT_FETCH_DATA_TIMEOUT_SECONDS;
    private static final int CREATIVE_VAST_FETCH_DATA_SIZE_LIMIT = DEFAULT_FETCH_DATA_SIZE_LIMIT;

    public static Byte[] fetchBinaryData(String binaryDataUrl, int dataSizeLimit, int timeoutSeconds)
            throws IOException {
        if (StringUtils.isEmpty(binaryDataUrl)) {
            return null;
        }

        URL url;
        HttpURLConnection httpConn;
        InputStream inputStream = null;
        try {
            if (StringUtils.startsWithIgnoreCase(binaryDataUrl, "https")) {
                url = new URL(null, binaryDataUrl, new sun.net.www.protocol.https.Handler());
                httpConn = (HttpsURLConnection) url.openConnection();
            } else {
                url = new URL(binaryDataUrl);
                httpConn = (HttpURLConnection) url.openConnection();
            }
            httpConn.setConnectTimeout(timeoutSeconds * 1000);
            httpConn.setReadTimeout(timeoutSeconds * 1000);
            httpConn.setRequestProperty("User-Agent", FETCH_USER_AGENT_VALUE);
            int responseCode = httpConn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                if (httpConn.getHeaderField("Content-Encoding")!=null && httpConn.getHeaderField("Content-Encoding").equals("gzip")){
                    inputStream = new GZIPInputStream(httpConn.getInputStream());
                } else {
                    inputStream = httpConn.getInputStream();
                }
            } else {
                throw new IOException("HTTP Response Error " + responseCode);
            }

            byte[] responseBytes = IOUtils.toByteArray(new BoundedInputStream(inputStream, dataSizeLimit));
            if (responseBytes != null && responseBytes.length >= dataSizeLimit) {
                throw new IOException("Content size exceeds the size limit");
            }

            return ArrayUtils.toObject(responseBytes);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static Byte[] fetchBinaryData(String binaryDataUrl) throws IOException {
        return fetchBinaryData(binaryDataUrl, DEFAULT_FETCH_DATA_SIZE_LIMIT, DEFAULT_FETCH_DATA_TIMEOUT_SECONDS);
    }

    public static Byte[] fetchCreativeVideoData(String videoDataUrl) throws IOException {
        return fetchBinaryData(videoDataUrl, CREATIVE_VIDEO_FETCH_DATA_SIZE_LIMIT,
                CREATIVE_VIDEO_FETCH_DATA_TIMEOUT_SECONDS);
    }

    public static Byte[] fetchCreativeImageData(String imageDataUrl) throws IOException {
        return fetchBinaryData(imageDataUrl, CREATIVE_IMAGE_FETCH_DATA_SIZE_LIMIT,
                CREATIVE_IMAGE_FETCH_DATA_TIMEOUT_SECONDS);
    }

    public static Byte[] fetchCreativeVastData(String vastDataUrl) throws IOException {
        return fetchBinaryData(vastDataUrl, CREATIVE_VAST_FETCH_DATA_SIZE_LIMIT,
                CREATIVE_VAST_FETCH_DATA_TIMEOUT_SECONDS);
    }

    public static String resolveCreativeLandingPageUrl(String url) throws Exception {
        DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(1000 * DEFAULT_FETCH_DATA_TIMEOUT_SECONDS)
                .setConnectTimeout(1000 * DEFAULT_FETCH_DATA_TIMEOUT_SECONDS)
                .setConnectionRequestTimeout(1000 * DEFAULT_FETCH_DATA_TIMEOUT_SECONDS)
                .build();
        CloseableHttpClient redirectHttpClient = HttpClients.custom()
                .setRedirectStrategy(redirectStrategy)
                .setDefaultRequestConfig(requestConfig)
                .build();

        CloseableHttpResponse httpResponse = null;
        String landingPageUrl = null;
        try {
            URL newUrl = new URL(url);
            URI uri = new URI(newUrl.getProtocol(), newUrl.getUserInfo(), newUrl.getHost(),
                    newUrl.getPort(), newUrl.getPath(), newUrl.getQuery(), newUrl.getRef());
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setHeader("User-Agent", ExternalContentFetcher.FETCH_USER_AGENT_VALUE);
            HttpClientContext httpContext = HttpClientContext.create();
            httpResponse = redirectHttpClient.execute(httpGet, httpContext);
            HttpHost httpHost = httpContext.getTargetHost();
            List<URI> httpRedirects = httpContext.getRedirectLocations();
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode >= HttpStatus.SC_OK && statusCode < HttpStatus.SC_MULTIPLE_CHOICES) {
                if (CollectionUtils.isNotEmpty(httpRedirects)) {
                    landingPageUrl = URIUtils.resolve(httpGet.getURI(), httpHost, httpRedirects).toASCIIString();
                } else {
                    landingPageUrl = url;
                }
            }
        } finally {
            if (httpResponse != null) {
                httpResponse.close();
            }
            redirectHttpClient.close();
        }
        return landingPageUrl;
    }
}

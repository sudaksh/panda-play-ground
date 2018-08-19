package mytest;
public class TestDetectLandingPage {

    public static void main(String[] args){
        ExternalContentFetcher externalContentFetcher = new ExternalContentFetcher();
        String url = "https://sonypictures.ru/Hotel_Transylvania_3/";
        try {
            externalContentFetcher.resolveCreativeLandingPageUrl(url);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

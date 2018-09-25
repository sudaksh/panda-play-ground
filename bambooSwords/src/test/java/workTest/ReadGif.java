package workTest;

import org.junit.Test;
import workspace.GifDecoder;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReadGif {

    String file1 = "/Users/rachelwang/Downloads/ezgif.com-resize.gif";
    public void wrong() throws Exception{

        byte[] bytes = Files.readAllBytes(new File(file1).toPath());
//        BufferedImage bufferedImage = readImage(bytes);
//        System.out.print(bufferedImage.getHeight() + " " + bufferedImage.getWidth());
        GifDecoder.GifImage gif = GifDecoder.read(bytes);
        System.out.println(gif.getHeight() + " " + gif.getWidth() + " " + gif.getFrameCount());

        isAnimatedGif(bytes);

    }

    public BufferedImage readImage (byte[] bytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(byteArrayInputStream);
        } catch (IOException e) {
            throw e;
        }
        return bufferedImage;
    }
    public boolean isAnimatedGif(byte[] data){
        ImageReader ir = ImageIO.getImageReadersBySuffix("gif").next();
        ImageInputStream iis;
        int images = 0;
        try {
            iis = ImageIO.createImageInputStream(new ByteArrayInputStream(data));
            ir.setInput(iis);
            images= ir.getNumImages(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("gif contains " + images + "images");
        return images > 1;
    }

    @Test
    public void test() throws Exception{
        wrong();
    }
}

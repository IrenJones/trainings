package concur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RGBColorMethods {

    public static final String SOURCE_FILE = "./src/main/java/concur/1124562.jpg";
    public static final String DEST_FILE = "./src/main/java/concur/res.jpg";

    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File(SOURCE_FILE));
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        // single thread
        long startTime = System.currentTimeMillis();
        recolorPatch(image, result, 0, 0, image.getWidth(), image.getHeight());
        long total = System.currentTimeMillis() - startTime;
        System.out.println("Single:" + total);

        startTime = System.currentTimeMillis();
        recolorMultithread(image, result, 20);
        total = System.currentTimeMillis() - startTime;
        System.out.println("Multi 20:" + total);

        startTime = System.currentTimeMillis();
        recolorMultithread(image, result, 10);
        total = System.currentTimeMillis() - startTime;
        System.out.println("Multi 10:" + total);

        startTime = System.currentTimeMillis();
        recolorMultithread(image, result, 5);
        total = System.currentTimeMillis() - startTime;
        System.out.println("Multi 5:" + total);

        File output = new File(DEST_FILE);
        ImageIO.write(result, "jpg", output);
    }

    public static void recolorMultithread(BufferedImage image, BufferedImage result, int numberOfThreads){
        List<Thread> threads = new ArrayList<>();
        int widthPatch = image.getWidth();
        int heightPatch = image.getHeight() / numberOfThreads;

        for(int i = 0; i < numberOfThreads; i++){
            final int multipl = i;
            Thread t = new Thread(() -> {
            int left = 0;
            int top = heightPatch * multipl;
            recolorPatch(image, result, left, top, widthPatch, heightPatch);
            });
            threads.add(t);
        }

        for(Thread tt: threads){
            tt.start();
        }

        for(Thread tt: threads){
            try {
                tt.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void recolorPatch(BufferedImage image, BufferedImage result, int x, int y, int n, int m){
        for(int i = x; i < x + n && i < image.getWidth(); i++){
            for(int j = y; j < y + m && j < image.getHeight(); j++){
                recoloring(image, result, i, j);
            }
        }
    }

    public static void recoloring(BufferedImage image, BufferedImage result, int x, int y){
        int rgbPixel = image.getRGB(x, y);

        int red = getRed(rgbPixel);
        int green = getGreen(rgbPixel);
        int blue = getBlue(rgbPixel);
        int newRed = red, newGreen = green, newBlue = blue;
        if(isShadeGray(red, green, blue)){
            newRed = Math.min(255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue - 20);
        }

        int resultPixel = createColor(newRed, newGreen, newBlue);
        result.setRGB(x, y, resultPixel);
    }

    // all components should have the similar colour intensity
    // 30 is set empirically
    public static boolean isShadeGray(int red, int green, int blue){
        return Math.abs(red - green) < 30 &&
                Math.abs(red - blue) < 30 &&
                Math.abs(blue - green) < 30;
    }

    public static int createColor(int red, int green, int blue){
        int res = 0;

        res = res | blue;
        res = res | green << 8;
        res = res | red << 16;

        // set alpha channel
        res = res | 0xFF000000;

        return res;
    }

    public static int getRed(int rgb){
        return rgb & 0x00FF0000 >> 16;
    }

    // second byte from the right -> need to shift 8 bit to the right
    public static int getGreen(int rgb){
        return rgb & 0x0000FF00 >> 8;
    }

    public static int getBlue(int rgb){
        return rgb & 0x000000FF;
    }
}

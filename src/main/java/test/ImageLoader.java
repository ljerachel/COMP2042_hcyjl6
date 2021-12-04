package test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    private BufferedImage img;


    public ImageLoader() {
        try {
            this.img = ImageIO.read(new File("src/main/resources/extralife.jpg"));

        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public BufferedImage getImage() {
        return this.img;
    }

    public BufferedImage getSubImage(int section) {
        return this.img.getSubimage(0, section * 25, 50, 25);
    }
}




package cw3;

import java.awt.Color;

/**
 * CPT105 2020 Coursework 3 Sample Methods
 */
public class CW3_Example {

    // Returns a new picture that is an upside down version the given picture.
    public static Picture upsideDown(Picture picture) {
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int x = 0; x < newPic.width(); x++) {
            for (int y = 0; y < newPic.height(); y++) {
                newPic.setColor(x, y, picture.getColor(x, newPic.height() - 1 - y));
            }
        }
        return newPic;
    }

    // Returns a new picture that is a grayscale version the given picture.
    public static Picture grayScale(Picture picture) {
        Picture newPic = new Picture(picture.width(), picture.height());
        double luminance = 0;
        int lum = 0;
        for (int x = 0; x < newPic.width(); x++) {
            for (int y = 0; y < newPic.height(); y++) {
                luminance = 0.299 * picture.getColor(x, y).getRed() + 0.587 * picture.getColor(x, y).getGreen() + 0.114 *
                        picture.getColor(x, y).getBlue();
                lum = (int) Math.round(luminance);
                newPic.setColor(x, y, new Color(lum, lum, lum));
            }
        }
        return newPic;
    }


    public static void main(String[] args) {
        Picture andrew = new Picture("C:\\Users\\Yifan Wang\\Downloads\\cw3\\Andrew.png");
        andrew.show();
        upsideDown(andrew).show();
        grayScale(andrew).show();
        //upsideDown(andrew).show();
        //grayScale(andrew).show();

        //Picture udAndrew = new Picture("src\\cw3\\Expected\\UpsideDownAndrew.png");
        //System.out.println(udAndrew.equals(upsideDown(andrew)));

        //Picture grayAndrew = new Picture("src\\cw3\\Expected\\GrayAndrew.png");
        //System.out.println(grayAndrew.equals(grayScale(andrew)));
    }
}


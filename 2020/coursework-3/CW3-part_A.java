package cw3;

import java.awt.Color;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.net.ProxySelector;

/**
 * CPT105 2020 Coursework 3 Part A
 */
public class CW3_Part_A {

    /****************
     * CW3 Part A.1 *
     ****************/

    // Returns a new picture that tilts it 30 degrees clockwise.
    public static Picture tilt(Picture picture) {
        Picture newPic = new Picture(picture.width(), picture.height());
        double theta = -Math.PI / 6;
        double colC = 0.5 * (picture.width() - 1);
        double rowC = 0.5 * (picture.height() - 1);

        for (int colT = 0; colT < picture.width(); ++colT) {
            for (int rowT = 0; rowT < picture.height(); ++rowT) {
                int colS = (int) ((colT - colC) * Math.cos(theta) - (rowT - rowC) * Math.sin(theta) + colC);
                int rowS = (int) ((colT - colC) * Math.sin(theta) + (rowT - rowC) * Math.cos(theta) + rowC);
                if (colS < newPic.width() && colS > -1 && rowS < newPic.height() && rowS > -1) {
                    newPic.setColor(colT, rowT, picture.getColor(colS, rowS));
                }
            }
        }

        return newPic;
    }


    /****************
     * CW3 Part A.2 *
     ****************/

// Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {

        int[] posCol = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int[] posRow = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] kernel = {-2, -1, 0, -1, 1, 1, 0, 1, 2};
        int filterR, filterG, filterB;
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                filterR = 0;
                filterG = 0;
                filterB = 0;

                for (int i = 0; i < 9; i++) {
                    Color color = picture.getColor(Math.floorMod(col + posCol[i], picture.width()), Math.floorMod(row + posRow[i], picture.height()));
                    int r = color.getRed();
                    filterR += r * kernel[i];
                    int g = color.getGreen();
                    filterG += g * kernel[i];
                    int b = color.getBlue();
                    filterB += b * kernel[i];
                }

                filterR = Math.max(0, filterR);
                filterR = Math.min(filterR, 255);
                filterG = Math.max(0, filterG);
                filterG = Math.min(filterG, 255);
                filterB = Math.max(0, filterB);
                filterB = Math.min(filterB, 255);

                newPic.setColor(col, row, new Color(filterR, filterG, filterB));
            }
        }
        return newPic;
    }

    /****************
     * CW3 Part A.3 *
     ****************/

// Returns a new picture that applies a blur filter to the given picture.
    public static Picture blur(Picture picture) {
        int[] posCol = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        int[] posRow = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        int[] kernel = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int filterR, filterG, filterB;
        float blurPara = 9.0F;

        Picture newPic = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                filterR = 0;
                filterG = 0;
                filterB = 0;

                for (int i = 0; i < 9; i++) {
                    Color color = picture.getColor(Math.floorMod(col + posCol[i], picture.width()), Math.floorMod(row + posRow[i], picture.height()));
                    int r = color.getRed();
                    filterR += r * kernel[i];
                    int g = color.getGreen();
                    filterG += g * kernel[i];
                    int b = color.getBlue();
                    filterB += b * kernel[i];
                }

                filterR = (int) Math.round(filterR / blurPara);
                filterG = (int) Math.round(filterG / blurPara);
                filterB = (int) Math.round(filterB / blurPara);

                filterR = Math.max(0, filterR);
                filterR = Math.min(filterR, 255);
                filterG = Math.max(0, filterG);
                filterG = Math.min(filterG, 255);
                filterB = Math.max(0, filterB);
                filterB = Math.min(filterB, 255);

                newPic.setColor(col, row, new Color(filterR, filterG, filterB));
            }
        }
        return newPic;
    }

    /****************
     * CW3 Part A.4 *
     ****************/

// Returns a new picture that applies an edge detection to the given picture.
    public static Picture edge(Picture picture) {

        int[] posCol = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int[] posRow = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] kernel1 = {-1, 0, 1, -2, 0, 2, -1, 0, 1};
        int[] kernel2 = {1, 2, 1, 0, 0, 0, -1, -2, -1};
        int gray1;
        int gray2;
        int gray;

        Picture newPic = new Picture(picture.width(), picture.height());
        Picture grayPic = CW3_Example.grayScale(picture);

        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {

                gray1 = 0;
                gray2 = 0;

                for (int i = 0; i < 9; i++) {
                    Color color = grayPic.getColor(Math.floorMod(col + posCol[i], picture.width()), Math.floorMod(row + posRow[i], picture.height()));
                    int y = color.getRed();
                    gray1 += y * kernel1[i];
                    gray2 += y * kernel2[i];
                }

                gray = (int) Math.sqrt(gray1 * gray1 + gray2 * gray2);
                gray = Math.max(0, gray);
                gray = Math.min(gray, 255);
                Color edge = new Color(255 - gray, 255 - gray, 255 - gray);
                newPic.setColor(col, row, edge);
            }
        }
        return newPic;
    }


    public static void main(String[] args) {

        Picture andrew = new Picture("C:\\Users\\Yifan Wang\\Downloads\\cw3\\Andrew.png");
        andrew.show();

        tilt(andrew).show();
        Picture tiltAndrew = new Picture("C:\\Users\\Yifan Wang\\Downloads\\cw3\\Expected\\TiltAndrew.png");
        System.out.println(tilt(andrew).equals(tiltAndrew));

        emboss(andrew).show();
        Picture embossAndrew = new Picture("C:\\Users\\Yifan Wang\\Downloads\\cw3\\Expected\\EmbossAndrew.png");
        System.out.println(emboss(andrew).equals(embossAndrew));

        blur(andrew).show();
        Picture blurAndrew = new Picture("C:\\Users\\Yifan Wang\\Downloads\\cw3\\Expected\\BlurAndrew.png");
        System.out.println(blur(andrew).equals(blurAndrew));

        edge(andrew).show();
        Picture edgeAndrew = new Picture("C:\\Users\\Yifan Wang\\Downloads\\cw3\\Expected\\EdgeAndrew.png");
        System.out.println(edge(andrew).equals(edgeAndrew));

    }

}
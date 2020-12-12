package cw3;

import java.awt.Color;

/**
 * CPT105 2020 Coursework 3 Part B
 */
public class CW3_Part_B {

    /****************
     * CW3 Part B.1 *
     ****************/

    // Original picture and positionally tranformed picture.
    private static Picture transformRotate(Picture src) {
        Picture dest = new Picture(src.width(), src.height());

        double theta = -Math.PI / (2 + (int) (Math.random() * 5));
        double colC = 0.5 * (src.width() - 1);
        double rowC = 0.5 * (src.height() - 1);

        for (int colT = 0; colT < src.width(); ++colT) {
            for (int rowT = 0; rowT < src.height(); ++rowT) {
                int colS = (int) ((colT - colC) * Math.cos(theta) - (rowT - rowC) * Math.sin(theta) + colC);
                int rowS = (int) ((colT - colC) * Math.sin(theta) + (rowT - rowC) * Math.cos(theta) + rowC);
                if (colS < dest.width() && colS > -1 && rowS < dest.height() && rowS > -1) {
                    dest.setColor(colT, rowT, src.getColor(colS, rowS));
                }
            }
        }

        return dest;
    }

    private static Picture transformSwirl(Picture src) {

        Picture dest = new Picture(src.width(), src.height());

        double helicity = 0.1;
        double colMid = (src.width() - 1) / 2;
        double rowMid = (src.height() - 1) / 2;
        double colDist, rowDist, radius, theta;

        for (int col = 0; col < src.width(); col++) {
            for (int row = 0; row < src.height(); row++) {
                colDist = col - colMid;
                rowDist = row - rowMid;

                radius = Math.sqrt(helicity * (Math.pow(colDist, 2) + Math.pow(rowDist, 2)));
                theta = (Math.PI / (256 + (int) (Math.random() * 1)) * radius * 2 + (2 + (int) (Math.random() * 5)));
                int colT = (int) (colDist * Math.cos(theta) - rowDist * Math.sin(theta) + colMid);
                int rowT = (int) (colDist * Math.sin(theta) + rowDist * Math.cos(theta) + rowMid);

                if (colT >= 0 && colT < src.width() && rowT >= 0 && rowT < src.height())
                    dest.setColor(col, row, src.getColor(colT, rowT));
            }
        }
        return dest;
    }

    private static Picture transformEnlarge(Picture src) {
        int scale = 2 + (int) (Math.random() * 4);
        Picture dest = new Picture(src.width() * scale, src.height() * scale);

        double kCol = src.width() / dest.width();
        double kRow = src.height() / dest.height();

        for (int col = 0; col < dest.width(); col++) {
            for (int row = 0; row < dest.height(); row++) {
                dest.setColor(col, row, src.getColor((int) col / scale, (int) row / scale));
            }
        }

        return dest;
    }

    private static Picture transformSplit(Picture src) {
        Picture dest = new Picture(src.width(), src.height());

        for (int col = 0; col < src.width() / 2; col++) {
            for (int row = 0; row < src.height() / 2; row++) {
                dest.setColor(col, row, src.getColor(src.width() / 2 + col, src.height() / 2 + row));
            }
        }
        for (int col = src.width() / 2; col < src.width(); col++) {
            for (int row = 0; row < src.height() / 2; row++) {
                dest.setColor(col, row, src.getColor(-src.width() / 2 + 1 + col, src.height() / 2 + row));
            }
        }
        for (int col = 0; col < src.width() / 2; col++) {
            for (int row = src.height() / 2; row < src.height(); row++) {
                dest.setColor(col, row, src.getColor(src.width() / 2 + col, -src.height() / 2 + 1 + row));
            }
        }
        for (int col = src.width() / 2; col < src.width(); col++) {
            for (int row = src.height() / 2; row < src.height(); row++) {
                dest.setColor(col, row, src.getColor(-src.width() / 2 + 1 + col, -src.height() / 2 + 1 + row));
            }
        }

        return dest;
    }

    private static Picture transformLeftRight(Picture src) {
        Picture dest = new Picture(src.width(), src.height());

        for (int col = 0; col < src.width(); col++) {
            for (int row = 0; row < src.height(); row++) {
                dest.setColor(col, row, src.getColor(src.width() - 1 - col, row));
            }
        }
        return dest;
    }

    private static Picture transformUpsideDown(Picture src) {
        Picture dest = new Picture(src.width(), src.height());

        for (int col = 0; col < src.width(); col++) {
            for (int row = 0; row < src.height(); row++) {
                dest.setColor(col, row, src.getColor(col, src.height() - 1 - row));
            }
        }
        return dest;
    }

    private static Picture transformWave(Picture src) {
        Picture dest = new Picture(src.width(), src.height());

        int rowWave;
        double factorWave = Math.floor(Math.random() * 9 + 1) / 10;

        for (int col = 0; col < src.width(); col++) {
            for (int row = 0; row < src.height(); row++) {
                dest.setColor(col, row, src.getColor(col, row));//new
                rowWave = (int) (row + 5 * Math.sin(col * factorWave));
                if (0 <= col && col < src.width() && 0 <= rowWave && rowWave < src.height()) {
                    dest.setColor(col, row, src.getColor(col, rowWave));//new
                }
            }
        }
        return dest;
    }

    public static Picture positionalTransform(Picture picture) {
        Picture process;
        process = transformSwirl(transformSplit(transformEnlarge(picture)));

        return mergePicture(picture, process);
    }


    /****************
     * CW3 Part B.2 *
     ****************/

    // Original picture and color tranformed picture.
    private static double noise() {
        return Math.random() * 0.5 + 0.5;
    }

    private static double colorBlend(double scale, double dest, double src) {
        return (scale * dest + (1.0 - scale) * src);
    }

    private static int inRange(int input) {
        return Math.min(255, (Math.max(input, 0)));
    }

    private static Picture filterGray(Picture src) {
        Picture dest = new Picture(src.width(), src.height());

        double luminance = 0;
        int lum = 0;
        for (int x = 0; x < dest.width(); x++) {
            for (int y = 0; y < dest.height(); y++) {
                luminance = 0.299 * src.getColor(x, y).getRed() + 0.587 * src.getColor(x, y).getGreen() + 0.114 *
                        src.getColor(x, y).getBlue();
                lum = (int) Math.round(luminance);
                dest.setColor(x, y, new Color(lum, lum, lum));
            }
        }
        return dest;
    }

    private static Picture filterFilm(Picture src) {
        Picture dest = new Picture(src.width(), src.height());
        int filterR, filterG, filterB;

        for (int col = 0; col < src.width(); col++) {
            for (int row = 0; row < src.height(); row++) {
                filterR = 0;
                filterG = 0;
                filterB = 0;

                filterR = (int) colorBlend(noise(), src.getColor(col, row).getRed() * 0.393 +
                                src.getColor(col, row).getGreen() * 0.769 + src.getColor(col, row).getBlue() * 0.188,
                        src.getColor(col, row).getRed());
                filterG = (int) colorBlend(noise(), src.getColor(col, row).getRed() * 0.349 +
                                src.getColor(col, row).getGreen() * 0.686 + src.getColor(col, row).getBlue() * 0.169,
                        src.getColor(col, row).getGreen());
                filterB = (int) colorBlend(noise(), src.getColor(col, row).getRed() * 0.272 +
                                src.getColor(col, row).getGreen() * 0.534 + src.getColor(col, row).getBlue() * 0.132,
                        src.getColor(col, row).getBlue());

                filterR = inRange(filterR);
                filterG = inRange(filterG);
                filterB = inRange(filterB);

                dest.setColor(col, row, new Color(filterR, filterG, filterB));
            }
        }
        return dest;
    }

    private static Picture filterDualColour(Picture src) {
        Picture dest = new Picture(src.width(), src.height());
        int colour = 24 + (int) (Math.random() * 72);

        for (int col = 0; col < src.width(); col++) {
            for (int row = 0; row < src.height(); row++) {
                if ((src.getColor(col, row).getRed() + src.getColor(col, row).getGreen() + src.getColor(col, row).getBlue()) / 3 > 90) {
                    dest.setColor(col, row, new Color(255 - colour, 255 - colour, 255 - colour));
                } else {
                    dest.setColor(col, row, new Color(colour, colour, colour));
                }
            }
        }
        return dest;
    }

    private static Picture filterShift(Picture src) {
        Picture dest = new Picture(src.width(), src.height());
        int filterR, filterG, filterB;
        int randomNum = 1 + (int) (Math.random() * 4);

        for (int col = 0; col < src.width(); col++) {
            for (int row = 0; row < src.height(); row++) {

                filterR = src.getColor(col, row).getRed() + 24 + (int) (Math.random() * 56);
                filterG = src.getColor(col, row).getGreen() + 24 + (int) (Math.random() * 56);
                filterB = src.getColor(col, row).getBlue() + 24 + (int) (Math.random() * 56);

                filterR = inRange(filterR);
                filterG = inRange(filterG);
                filterB = inRange(filterB);

                if (randomNum == 1) dest.setColor(col, row, new Color(filterG, filterB, filterR));
                else if (randomNum == 2)
                    dest.setColor(col, row, new Color(filterG, filterR, filterB));
                else if (randomNum == 3)
                    dest.setColor(col, row, new Color(filterB, filterR, filterG));
                else if (randomNum == 4)
                    dest.setColor(col, row, new Color(filterB, filterG, filterR));
                else
                    dest.setColor(col, row, new Color(filterR, filterB, filterG));
            }
        }
        return dest;
    }

    private static Picture filterFrost(Picture src) {
        Picture dest = new Picture(src.width(), src.height());
        int randomRange = 3 + (int) (Math.random() * 6);
        int range = 0;

        for (int col = 0; col < src.width(); col++) {
            for (int row = 0; row < src.height(); row++) {
                dest.setColor(col, row, src.getColor(col, row));
            }
        }
        for (int col = randomRange; col < src.width() - randomRange; col++) {
            for (int row = randomRange; row < src.height() - randomRange; row++) {
                range = (int) (Math.random() * randomRange) + 1;
                dest.setColor(col, row,
                        src.getColor(
                                (col + (int) (Math.random() * range) + 1 - (range + 1) / 2),
                                (row + (int) (Math.random() * range) + 1 - (range + 1) / 2)
                        )
                );
            }
        }
        return dest;
    }

    private static Picture filterReverseColour(Picture src) {
        Picture dest = new Picture(src.width(), src.height());
        int filterR, filterG, filterB;

        for (int col = 0; col < src.width(); col++) {
            for (int row = 0; row < src.height(); row++) {
                filterR = 255 - src.getColor(col, row).getRed();
                filterG = 255 - src.getColor(col, row).getGreen();
                filterB = 255 - src.getColor(col, row).getBlue();
                dest.setColor(col, row, new Color(filterR, filterG, filterB));
            }
        }
        return dest;
    }

    public static Picture colorTransform(Picture picture) {
        Picture process = new Picture(picture.width(), picture.height());


        process = filterFilm(picture);
//        filterGray(process, process);
//        filterReverseColour(process,process);
//        filter2077(process,process);
//        filterDualColour(picture,process);

        return mergePicture(picture, process);
    }

    private static Picture mergePicture(Picture picture, Picture process) {
        Picture result = new Picture(picture.width() + 1 + process.width(), Math.max(picture.height(), process.height()));
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                result.setColor(col, row, picture.getColor(col, row));
            }
        }
        for (int col = 0; col < process.width(); col++) {
            for (int row = 0; row < process.height(); row++) {
                result.setColor(picture.width() + 1 + col, row, process.getColor(col, row));
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Picture input = new Picture("path\to\Test.png");

        input.show();
        transformSwirl(input).show();
        transformWave(input).show();
        transformEnlarge(input).show();
        transformRotate(input).show();
        transformUpsideDown(input).show();
        transformLeftRight(input).show();
        transformSplit(input).show();

        filterReverseColour(input).show();
        filterFilm(input).show();
        filterDualColour(input).show();
        filterGray(input).show();
        filterFrost(input).show();
        filterShift(input).show();

        positionalTransform(input).show();
        colorTransform(input).show();

    }
}
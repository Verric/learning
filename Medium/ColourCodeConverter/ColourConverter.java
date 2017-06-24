import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ColourConverter {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                if(line.startsWith("#"))   { sb.append(hex2rgb(line)).append('\n'); continue;}
                if (line.startsWith("("))  { sb.append(cmyk2rgb(line)).append('\n'); continue;}
                if(line.startsWith("HSV")) { sb.append(hsv2rgb(line)).append('\n'); continue;}
                if(line.startsWith("HSL"))  sb.append(hsl2rgb(line)).append('\n');
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.print(sb.toString());
    }
    private static String hex2rgb(String input){

        Color c = Color.decode(input);
        return String.format("RGB(%d,%d,%d)",c.getRed(),c.getGreen(),c.getBlue());

    }

    private static String cmyk2rgb(String input){

        input = input.replace("(","");
        input = input.replace(")","");

        String[] temp = input.split(",");

        double cyan = Double.parseDouble(temp[0]);
        double magenta = Double.parseDouble(temp[1]);
        double yellow = Double.parseDouble(temp[2]);
        double key= Double.parseDouble(temp[3]);

        double black = (1 - key);
        int red = (int)Math.round(black * (255 * (1-cyan)));
        int green = (int)Math.round(black * (255 * (1-magenta)));
        int blue = (int)Math.round(black * (255 * (1-yellow)));

        return String.format("RGB(%d,%d,%d)",red,green,blue);

    }

    private static String hsv2rgb(String input){

        String[] temp = input.replaceAll("\\D+"," ").trim().split(" ");
        Color c = Color.getHSBColor(
                Float.parseFloat(temp[0])/360.0f,
                Float.parseFloat(temp[1])/100.0f,
                Float.parseFloat(temp[2])/100.0f);

        return String.format("RGB(%d,%d,%d)",c.getRed(),c.getGreen(),c.getBlue());
    }

    private static String hsl2rgb(String input){

        String[] temp = input.replaceAll("\\D+"," ").trim().split(" ");
        Color c = new Color(HSLColor.toRGB(
                Float.parseFloat(temp[0])/360.0f,
                Float.parseFloat(temp[1])/100.0f,
                Float.parseFloat(temp[2])/100.0f,
                1.0f));

        return String.format("RGB(%d,%d,%d)",c.getRed(),c.getGreen(),c.getBlue());
    }
}
/*
* @(#)HSLColor.java
*
* $Date$
*
* Copyright (c) 2011 by Jeremy Wood.
* All rights reserved.
*
* The copyright of this software is owned by Jeremy Wood.
* You may not use, copy or modify this software, except in
* accordance with the license agreement you entered into with
* Jeremy Wood. For details see accompanying license terms.
*
* This software is probably, but not necessarily, discussed here:
* https://javagraphics.java.net/
*
* That site should also contain the most recent official version
* of this software.  (See the SVN repository for more details.)
*/
        /**
 *  This class interfaces with colors in terms of Hue, Saturation and Luminance.
 *  <P>This is copied from Rob Camick's class here:
 *  <br>http://tips4java.wordpress.com/2009/07/05/hsl-color/
 *
 * @see <a href="http://tips4java.wordpress.com/2009/07/05/hsl-color/">HSL Color</a>
 */
        class HSLColor {
            public static int toRGB(float h, float s, float l, float alpha) {

                float q;

                if (l < 0.5)
                    q = l * (1 + s);
                else
                    q = (l + s) - (s * l);

                float p = 2 * l - q;

                int r =  Math.round(255 * Math.max(0, HueToRGB(p, q, h + (1.0f / 3.0f)))); // -- diff rounded result
                int g =  Math.round(255 * Math.max(0, HueToRGB(p, q, h))); //-- ^^
                int b =  Math.round(255 * Math.max(0, HueToRGB(p, q, h - (1.0f / 3.0f))));// -- ^^

                int alphaInt = (int) (255 * alpha);

                return (alphaInt << 24) + (r << 16) + (g << 8) + (b);
            }

            private static float HueToRGB(float p, float q, float h) {
                if (h < 0) h += 1;

                if (h > 1) h -= 1;

                if (6 * h < 1) {
                    return p + ((q - p) * 6 * h);
                }

                if (2 * h < 1) {
                    return q;
                }

                if (3 * h < 2) {
                    return p + ((q - p) * 6 * ((2.0f / 3.0f) - h));
                }

                return p;
            }
        }
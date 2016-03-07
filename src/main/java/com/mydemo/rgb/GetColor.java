package com.mydemo.rgb;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GetColor {

    public void color(String path, int myX, int myY, int myW, int myH) throws IOException {

        BufferedImage buimage = ImageIO.read(new File(path));//换上你的文件名

        int r = 0;
        int b = 0;
        int g = 0;

        int w = buimage.getWidth();
        int h = buimage.getHeight();
        int minX = buimage.getMinX();
        int minY = buimage.getMinY();

        RGB rgb;
        Map<RGB, Integer> map = new HashMap();

        if ((myX < minX || myX > minX + w) || (myY < minY || myY > minY + w) || (myX + myW) > w || (myY + myH) > h) {
            System.out.println("坐标或长宽不符合要求!");
            return;
        }

        for (int x = myX; x < myX + myW; x++) {
            for (int y = myY; y < myH + myY; y++) {
                Object data = buimage.getRaster().getDataElements(x, y, null);
                r = buimage.getColorModel().getRed(data);
                g = buimage.getColorModel().getGreen(data);
                b = buimage.getColorModel().getBlue(data);
                rgb = new RGB(r, g, b);
                if (!map.containsKey(rgb)) {
                    map.put(rgb, 1);
                } else {
                    int count = map.get(rgb) + 1;
                    map.put(rgb, count);
                }
            }
        }

        getRatio(map, myW * myH);
    }

    public static void getRatio(Map<RGB, Integer> map,int total){
        Iterator iterator = map.entrySet().iterator();
        String str = "";
        int max = 0;
        while(iterator.hasNext()){
            Entry entry = (Entry) iterator.next();
            RGB key = (RGB) entry.getKey();
            if ((int) entry.getValue() > max){
                max = (int) entry.getValue();
                str = key.toString() + "  " + Integer.toString(100*max/total) + "%";
            }
        }
        System.out.println(str);
    }

}

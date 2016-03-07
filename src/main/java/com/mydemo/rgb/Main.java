package com.mydemo.rgb;

import com.mydemo.rgb.GetColor;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        GetColor getColor = new GetColor();
        getColor.color("D:/wacai.jpg", 10, 10, 10, 20);
    }
}

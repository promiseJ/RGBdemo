package com.mydemo.rgb;


import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        GetColor getColor = new GetColor();
        getColor.color("C:\\Users\\wacai\\Desktop\\wacai.jpg", 10, 10, 100, 20);
    }
}

package com.my.concurrency.test;

import javax.swing.*;
import java.io.File;

public class TestAnything {

    public static void main(String[] args) {
        String rootPath = System.getProperty("user.dir");
        System.out.println(rootPath);
        String imgPath = rootPath + "\\src\\main\\resources\\pics\\checkout_unavailable.png";
        imgPath = imgPath.replace("/", File.separator);
        System.out.println(imgPath);


        File file = new File(imgPath);
        ImageIcon imageIcon = new ImageIcon("src\\main\\resources\\pics\\checkout_unavailable.png");
        System.out.println(file.exists());


    }
}

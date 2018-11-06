package com.my.concurrency.test;

import java.util.Date;

public class TestAnything {

    public static void main(String[] args) {
//        String rootPath = System.getProperty("user.dir");
//        System.out.println(rootPath);
//        String imgPath = rootPath + "\\src\\main\\resources\\pics\\checkout_unavailable.png";
//        imgPath = imgPath.replace("/", File.separator);
//        System.out.println(imgPath);
//
//
//        File file = new File(imgPath);
//        ImageIcon imageIcon = new ImageIcon("src\\main\\resources\\pics\\checkout_unavailable.png");
//        JFrame jFrame = new JFrame();
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setVisible(true);
//        jFrame.add(new JLabel(imageIcon));
//
//
//
//        String regex = "^[0-9]*$";
//        String testString = "213";
//        boolean matchFlag = Pattern.matches(regex, testString);
//        System.out.println(matchFlag);

//        final List<Integer> strings = Collections.synchronizedList(new ArrayList<Integer>());
//        new Thread() {
//            @Override
//            public void run() {
//                int count = 0;
//                while (true) {
//                    strings.add(count);
//                    System.out.println("produce " + count);
//                    count++;
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.run();
//        new TestFom();
        System.out.println(new Date());
    }

}

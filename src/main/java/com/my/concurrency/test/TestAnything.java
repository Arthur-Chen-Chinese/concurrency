package com.my.concurrency.test;

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
//        System.out.println(new Date());
//        LinkedList<Customer> customers = new LinkedList<>();
//        customers.add(new Customer());
//        Customer remove = customers.remove();
//        System.out.println(remove);
//
//        Queue test1 = new LinkedList<Customer>();
//
//        test1.add(new Customer());
//        System.out.println(test1.poll());
////
//
//        for (int i = 0; i < 5; i++) {
//            for (Queue q :
//                    test1) {
//                q.add(new Customer());
//            }
//        }
//        for (int i = 0; i < 5; i++) {
//            for (Queue q :
//                    test1) {
//                Customer poll = (Customer) q.poll();
//                System.out.println(poll);
//
//            }
//        }
//        System.out.println(new Byte("0") == false);
//
//        Customer customer = new Customer();
//        customer.setNumOfProducts(123);
//        customer.setArrivedTime(new Date());
//        customer.setCheckoutId(0);
//        customer.setCheckStartTime(new Date(0));
//        customer.setCheckEndTime(new Date(0));
//        customer.setFinishedTime(new Date());
//        customer.setLostFlag(new Byte("1"));
//        DbHelper dbHelper = new DbHelper();
//        dbHelper.insertACustomer(customer);
//        System.out.println(customer.getId());
//        Checkout checkout = new Checkout();
//        DbHelper dbHelper = new DbHelper();
//        dbHelper.insertACheckout(checkout);
//        System.out.println(checkout.getId());

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 3; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    while (true) {
//                        System.out.println(Thread.currentThread().getName() + "" + new Date());
//                    }
//                }
//            };
//            executorService.execute(runnable);
//        }
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        executorService.shutdownNow();
        MyTestThread myTestThread = new MyTestThread();
        Thread thread = new Thread(myTestThread);
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myTestThread.stopThread();


    }

}

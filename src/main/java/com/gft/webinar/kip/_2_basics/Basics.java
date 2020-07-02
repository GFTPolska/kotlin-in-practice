package com.gft.webinar.kip._2_basics;

public class Basics {

    public static final Runnable task = () -> System.out.println("Hello, Kotliners from Java! BTW, PI is: " + Webinar.PI);

    public static void main(String[] args) {

        var url = Basics.class.getResource("resource.txt");
        System.out.println(url);

        task.run();
    }

}

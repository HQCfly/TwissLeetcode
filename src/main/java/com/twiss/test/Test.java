package com.twiss.test;

/**
 * @Author: Twiss
 * @Date: 2022/3/11 2:04 下午
 */
public class Test {


    public static void main(String[] args) {
        int a = 42;
        System.out.println(~a);
        MyThread myThread = new MyThread();

    }
}
class MyThread implements Runnable {
    Thread t;

    MyThread() {
        t = new Thread(this, "My Thread");
        t.start();
    }

    @Override
    public void run() {

    }
}
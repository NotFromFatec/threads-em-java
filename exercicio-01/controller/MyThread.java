package controller;

public class MyThread extends Thread {
    int index = 0;

    public MyThread(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().threadId();
        System.out.println(index + ": " + threadId);
    }
}

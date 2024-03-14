package view;

import controller.MyThread;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new MyThread(i);
            thread.start();
        }
    }
}

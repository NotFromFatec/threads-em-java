package view;

import controller.MyThread;

public class Main {
    public static void main(String[] args) {
        String[] servidores = {"uol.com.br", "terra.com", "google.com"};
        Thread[] threads = new Thread[servidores.length];

        for (int i = 0; i < servidores.length; i++) {
            threads[i] = new MyThread(servidores[i]);
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

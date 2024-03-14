package controller;

public class MyThread extends Thread {
    int index = 0;
    int[] vector;
    double elapsedTime = 999;

    public MyThread(int index, int[] vector) {
        this.index = index;
        this.vector = vector;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();

        if (index % 2 == 0) {
            for (int i = 0; i < vector.length; i++) { }
        } else {
            for (int value : vector) { }
        }

        long endTime = System.nanoTime();
        elapsedTime = (double)(endTime - startTime) / 1_000_000_000.0;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }
}

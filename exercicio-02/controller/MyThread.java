package controller;

public class MyThread extends Thread {
    int index = 0;
    int[] row;

    public MyThread(int index, int[] row) {
        this.index = index;
        this.row = row;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        System.out.println(index + ": " + sum);
    }
}

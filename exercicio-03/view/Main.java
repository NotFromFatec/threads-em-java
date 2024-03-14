package view;

import java.util.Random;

import controller.MyThread;

public class Main {
    public static void main(String[] args) {
        int[] vetor = generateRandomVector(1000);

        MyThread threadPar = new MyThread(1, vetor);
        MyThread threadImpar = new MyThread(2, vetor);

        threadPar.start();
        threadImpar.start();

        try {
            threadPar.join();
            threadImpar.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tempo total (for): " + threadPar.getElapsedTime() + " segundos");
        System.out.println("Tempo total (foreach): " + threadImpar.getElapsedTime() + " segundos");
    }

    static int[] generateRandomVector(int size) {
        int[] vetor = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            vetor[i] = random.nextInt(100) + 1;
        }

        return vetor;
    }
}

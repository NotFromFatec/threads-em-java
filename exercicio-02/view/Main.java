package view;

import java.util.Random;

import controller.MyThread;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix(3, 5);

        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread(i, matrix[i]);
            thread.start();
        }
    }

    static int[][] generateRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }

        return matrix;
    }
}

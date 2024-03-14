package view;

import controller.Sapo;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        int numSapos = 5;
        int distanciaMaxima = 100; 
        int tamanhoMaximoSalto = 10; 
        AtomicInteger colocacao = new AtomicInteger(1);

        Sapo[] sapos = new Sapo[numSapos];
        for (int i = 0; i < numSapos; i++) {
            sapos[i] = new Sapo(i + 1, distanciaMaxima, tamanhoMaximoSalto, colocacao);
            sapos[i].start();
        }

        for (Sapo sapo : sapos) {
            try {
                sapo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        bubbleSort(sapos);

        System.out.println("\nResultados da corrida (por ordem de chegada):");
        for (Sapo sapo : sapos) {
            System.out.println("Sapo " + sapo.getSapoId() + ": Colocação " + sapo.getColocacao());
        }
    }

    static void bubbleSort(Sapo[] sapos) {
        int n = sapos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sapos[j].getColocacao() > sapos[j + 1].getColocacao()) {
                    Sapo temp = sapos[j];
                    sapos[j] = sapos[j + 1];
                    sapos[j + 1] = temp;
                }
            }
        }
    }
}

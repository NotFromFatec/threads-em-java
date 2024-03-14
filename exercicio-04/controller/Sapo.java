package controller;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Sapo extends Thread {
    int sapoId;
    int distanciaMaxima;
    int tamanhoMaximoSalto;
    AtomicInteger colocacaoGlobal;
    int colocacao = 0;

    public Sapo(int sapoId, int distanciaMaxima, int tamanhoMaximoSalto, AtomicInteger colocacaoGlobal) {
        this.sapoId = sapoId;
        this.distanciaMaxima = distanciaMaxima;
        this.tamanhoMaximoSalto = tamanhoMaximoSalto;
        this.colocacaoGlobal = colocacaoGlobal;
    }

    @Override
    public void run() {
        int distanciaPercorrida = 0;
        Random random = new Random();

        while (distanciaPercorrida < distanciaMaxima) {
            int salto = random.nextInt(tamanhoMaximoSalto + 1); 
            distanciaPercorrida += salto;

            System.out.println("Sapo " + sapoId + " deu um salto de " + salto + " metros. Distância percorrida: " + distanciaPercorrida + " metros.");

            if (distanciaPercorrida >= distanciaMaxima) {
                colocacao = colocacaoGlobal.getAndIncrement();
                System.out.println("Sapo " + sapoId + " chegou em " + colocacao + "!");
                break;
            }
        }
    }

    public int getSapoId() {
        return sapoId;
    }

    public int getColocacao() {
        return colocacao;
    }
}

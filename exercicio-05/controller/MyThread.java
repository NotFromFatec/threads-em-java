package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyThread extends Thread {
    String servidor;

    public MyThread(String servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {
            int tempoTotal = 0;
            String osName = System.getProperty("os.name").toLowerCase();

            String comando;
            if (osName.contains("linux")) {
                comando = "ping -c 10 " + servidor;
            } else {
                System.out.println("Não é linux, mas ...");
                comando = "ping -n 10 " + servidor;
            }

            Process process = Runtime.getRuntime().exec(comando);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                if (line.contains("ms TTL")) {
                    int tempo = Integer.parseInt(line.split("ms")[0].split("=")[line.split("ms")[0].split("=").length - 1]);

                    tempoTotal += tempo;
                    System.out.println(servidor + " - " + tempo + "ms");
                }
            }
            process.waitFor();

            double tempoMedio = (double)tempoTotal / 10.0;
            System.out.println(servidor + " - Tempo médio: " + tempoMedio + " ms");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

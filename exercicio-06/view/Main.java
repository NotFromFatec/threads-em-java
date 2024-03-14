import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame {
    private JLabel carro1 = new JLabel("Carro 1");
    private JLabel carro2 = new JLabel("Carro 2");
    private JButton correr = new JButton("Correr");
    private JTextField vencedor = new JTextField();
    private JTextField perdedor = new JTextField();

    private int distancia = 100; 
    private int velocidadeMaxima = 10; 

    public Main() {
        setTitle("Drag Race");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        carro1.setBounds(10, 30, 100, 20);
        add(carro1);

        carro2.setBounds(10, 60, 100, 20);
        add(carro2);

        correr.setBounds(10, 90, 80, 30);
        add(correr);

        vencedor.setBounds(150, 90, 120, 20);
        add(vencedor);

        perdedor.setBounds(150, 120, 120, 20);
        add(perdedor);

        correr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                correr.setEnabled(false); 

                Timer timer = new Timer(100, new ActionListener() {
                    Random rand = new Random();
                    int posicaoCarro1 = 0;
                    int posicaoCarro2 = 0;

                    public void actionPerformed(ActionEvent e) {
                        posicaoCarro1 += rand.nextInt(velocidadeMaxima + 1);
                        posicaoCarro2 += rand.nextInt(velocidadeMaxima + 1);

                        carro1.setLocation(posicaoCarro1, carro1.getY());
                        carro2.setLocation(posicaoCarro2, carro2.getY());

                        if (posicaoCarro1 >= distancia || posicaoCarro2 >= distancia) {
                            if (posicaoCarro1 >= distancia) {
                                vencedor.setText("Carro 1");
                                perdedor.setText("Carro 2");
                            } else {
                                vencedor.setText("Carro 2");
                                perdedor.setText("Carro 1");
                            }
                            ((Timer) e.getSource()).stop(); 
                        }
                    }
                });

                timer.start();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}

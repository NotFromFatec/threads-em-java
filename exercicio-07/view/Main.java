import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame {
    private JTextField slot1 = new JTextField();
    private JTextField slot2 = new JTextField();
    private JTextField slot3 = new JTextField();
    private JButton jogar = new JButton("Jogar");

    public Main() {
        setTitle("Caça-Níquel");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        slot1.setBounds(50, 30, 50, 30);
        add(slot1);

        slot2.setBounds(120, 30, 50, 30);
        add(slot2);

        slot3.setBounds(190, 30, 50, 30);
        add(slot3);

        jogar.setBounds(100, 80, 80, 30);
        add(jogar);

        jogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jogar.setEnabled(false); 

                Timer timer = new Timer(100, new ActionListener() {
                    Random rand = new Random();
                    int giros = rand.nextInt(150) + 1; 

                    public void actionPerformed(ActionEvent e) {
                        int numero1 = rand.nextInt(7) + 1;
                        int numero2 = rand.nextInt(7) + 1;
                        int numero3 = rand.nextInt(7) + 1;

                        slot1.setText(String.valueOf(numero1));
                        slot2.setText(String.valueOf(numero2));
                        slot3.setText(String.valueOf(numero3));

                        giros--;
                        if (giros == 0) {
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

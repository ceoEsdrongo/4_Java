import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(5, 2));

        JTextField numero1 = new JTextField();
        JTextField numero2 = new JTextField();
        JTextField risultato = new JTextField();
        risultato.setEditable(false);

        JButton sommaButton = new JButton("SOMMA");
        JButton sottraiButton = new JButton("SOTTRAI");
        JButton moltiplicaButton = new JButton("MOLTIPLICA");
        JButton dividiButton = new JButton("DIVIDI");
        JButton resetButton = new JButton("RESET");
        JButton esciButton = new JButton("ESCI");

        frame.add(new JLabel("Numero 1:"));
        frame.add(numero1);
        frame.add(new JLabel("Numero 2:"));
        frame.add(numero2);
        frame.add(new JLabel("Risultato:"));
        frame.add(risultato);
        frame.add(sommaButton);
        frame.add(sottraiButton);
        frame.add(moltiplicaButton);
        frame.add(dividiButton);
        frame.add(resetButton);
        frame.add(esciButton);

        sommaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int n1 = Integer.parseInt(numero1.getText());
                    int n2 = Integer.parseInt(numero2.getText());
                    risultato.setText(String.valueOf(n1 + n2));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Errore: inserire numeri validi.");
                }
            }
        });

        sottraiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int n1 = Integer.parseInt(numero1.getText());
                    int n2 = Integer.parseInt(numero2.getText());
                    risultato.setText(String.valueOf(n1 - n2));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Errore: inserire numeri validi.");
                }
            }
        });

        moltiplicaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int n1 = Integer.parseInt(numero1.getText());
                    int n2 = Integer.parseInt(numero2.getText());
                    risultato.setText(String.valueOf(n1 * n2));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Errore: inserire numeri validi.");
                }
            }
        });

        dividiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int n1 = Integer.parseInt(numero1.getText());
                    int n2 = Integer.parseInt(numero2.getText());
                    if (n2 != 0) {
                        risultato.setText(String.valueOf((double) n1 / n2));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Errore: divisione per zero.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Errore: inserire numeri validi.");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numero1.setText("");
                numero2.setText("");
                risultato.setText("");
                numero1.requestFocus();
            }
        });

        esciButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Gestione del focus con TAB e INVIO
        numero1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    numero2.requestFocus();
                }
            }
        });

        numero2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sommaButton.requestFocus();
                }
            }
        });

        sommaButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sommaButton.doClick();
                }
            }
        });

        sottraiButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sottraiButton.doClick();
                }
            }
        });

        moltiplicaButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    moltiplicaButton.doClick();
                }
            }
        });

        dividiButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dividiButton.doClick();
                }
            }
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class VisualContact {
    private Rubrica rubrica;
    private JFrame frame;
    private JTextArea textArea;
    private JLabel photoLabel;

    public VisualContact() {
        rubrica = new Rubrica();

        frame = new JFrame("Rubrica con Foto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton addButton = new JButton("Aggiungi");
        JButton searchButton = new JButton("Cerca");

        panel.add(addButton);
        panel.add(searchButton);
        frame.add(panel, BorderLayout.SOUTH);

        photoLabel = new JLabel();
        photoLabel.setHorizontalAlignment(JLabel.CENTER);
        updatePhoto("default.png");
        frame.add(photoLabel, BorderLayout.EAST);

        addButton.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Nome:");
            String cognome = JOptionPane.showInputDialog("Cognome:");
            String numero = JOptionPane.showInputDialog("Numero:");

            JFileChooser fileChooser = new JFileChooser();
            String fotoPath = "default.png";

            if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fotoPath = selectedFile.getAbsolutePath();
            }

            Contatto c = new Contatto(nome, cognome, numero, fotoPath);
            rubrica.aggiungiContatto(c);
            JOptionPane.showMessageDialog(frame, "Contatto aggiunto!");
        });

        searchButton.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Nome:");
            String cognome = JOptionPane.showInputDialog("Cognome:");

            Contatto trovato = rubrica.cercaContatto(nome, cognome);
            if (trovato != null) {
                textArea.setText("Nome: " + trovato.getNome() + "\nCognome: " + trovato.getCognome() + "\nNumero: " + trovato.getNumero());
                updatePhoto(trovato.getFoto());
            } else {
                JOptionPane.showMessageDialog(frame, "Contatto non trovato!");
            }
        });

        frame.setVisible(true);
    }

    private void updatePhoto(String imagePath) {
        File imgFile = new File(imagePath);
        if (!imgFile.exists()) {
            imagePath = "default.png";
        }
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        photoLabel.setIcon(icon);
    }
}

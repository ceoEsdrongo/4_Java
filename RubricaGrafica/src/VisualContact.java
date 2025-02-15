import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualContact {
    private Rubrica rubrica;
    private JFrame frame;
    private JTextArea textArea;

    public VisualContact() {
        rubrica = new Rubrica();
        frame = new JFrame("Rubrica Telefonica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton addButton = new JButton("Aggiungi");
        JButton deleteButton = new JButton("Elimina");
        JButton searchButton = new JButton("Cerca");
        JButton viewButton = new JButton("Visualizza");

        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(searchButton);
        panel.add(viewButton);
        frame.add(panel, BorderLayout.SOUTH);

        // Listener per aggiungere un contatto
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Inserisci Nome:");
                String cognome = JOptionPane.showInputDialog("Inserisci Cognome:");
                String numero = JOptionPane.showInputDialog("Inserisci Numero:");
                if (nome != null && cognome != null && numero != null) {
                    rubrica.aggiungiContatto(new Contatto(nome, cognome, numero));
                    JOptionPane.showMessageDialog(frame, "Contatto aggiunto con successo.");
                }
            }
        });

        // Listener per eliminare un contatto
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rubrica.cancella();
            }
        });

        // Listener per cercare un contatto
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String risultato = rubrica.ricerca();
                JOptionPane.showMessageDialog(frame, risultato);
            }
        });

        // Listener per visualizzare la rubrica
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(rubrica.visualizzaRubrica());
            }
        });

        frame.setVisible(true);
    }
}

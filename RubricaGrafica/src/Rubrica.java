import java.io.*;
import java.util.Vector;

public class Rubrica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Vector<Contatto> rubrica;
    private final String nomeFile = "rubrica.dat";

    public Rubrica() {
        rubrica = caricaRubrica();
    }

    public void aggiungiContatto(Contatto c) {
        rubrica.add(c);
        salvaRubrica();
    }

    public Contatto cercaContatto(String nome, String cognome) {
        for (Contatto c : rubrica) {
            if (c.getNome().equalsIgnoreCase(nome) && c.getCognome().equalsIgnoreCase(cognome)) {
                return c;
            }
        }
        return null;
    }

    private void salvaRubrica() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(rubrica);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Vector<Contatto> caricaRubrica() {
        File file = new File(nomeFile);
        if (!file.exists()) return new Vector<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Vector<Contatto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Vector<>();
        }
    }
}

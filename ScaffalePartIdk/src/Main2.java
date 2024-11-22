import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main2 {
    public static void main(String[] args) {
        try {
            File f = new File("biblioteca.dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Libro p = (Libro) ois.readObject();
            System.out.println("leggo");
            System.out.println(p);

            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
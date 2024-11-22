import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Persona p = new Persona("mario", "rossi");
        try {
            File f = new File("save.dat");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.flush();
            System.out.println("scrivo");

            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
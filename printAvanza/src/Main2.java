import java.io.*;

public class Main2 {
    public static void main(String[] args) {
        try {
            File f = new File("save.dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Persona p = (Persona) ois.readObject();
            System.out.println("leggo");
            System.out.println(p);

            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
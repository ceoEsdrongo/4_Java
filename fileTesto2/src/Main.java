import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomeFile = "fileTesto.txt";
        try {
            FileInputStream fin = new FileInputStream(nomeFile);
            
            Scanner in = new Scanner(fin);
            while (in.hasNextLine()){
                String linea = in.nextLine();
                System.out.println(linea);
            }
        }catch (FileNotFoundException e){
            System.out.println("eccezione "+e);
            e.printStackTrace();
        }
        
        
    }
}
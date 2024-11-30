import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        RandomAccessFile f = new RandomAccessFile("interi.dat", "rw");
        System.out.println("scrivo...");
        for (int i = 1; i <= 10; i++) {
            f.write(i);
            f.close();
            System.out.println("finito");
            
            
            //lettura
            System.out.println("leggo");
            f = new RandomAccessFile("interi.dat", "r");
            for (int j = 1; j <= 10; j++) {
                int numeroLetto = f.readInt();
                System.out.println(numeroLetto + " ");


                f = new RandomAccessFile("interi.dat", "r");
                f.seek(4);
                int nLetto = f.readInt();
                System.out.println("numero letto = " + nLetto);
                long fp = f.getFilePointer();
                System.out.println("file pointer =" + fp);

                f.seek(4);
                nLetto = f.readInt();
                System.out.println("numero letto prima = " + nLetto);

                f.seek(4);
                f.writeInt(4);

                f.seek(4);
                nLetto = f.readInt();
                System.out.println("numero letto prima = "+nLetto);
            }
        }
    }
}

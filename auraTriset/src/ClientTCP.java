import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6789);
        System.out.println("Connesso al server!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Inserisci la tua mossa (es. 00 per riga 0 colonna 0): ");
            String mossa = scanner.nextLine();

            if (mossa.equalsIgnoreCase("quit")) {
                out.println("quit");
                break;
            }

            out.println(mossa);

            String response = in.readLine();
            while (in.ready()) {
                response += "\n" + in.readLine();
            }

            System.out.println(response);

            if (response.contains("win") || response.contains("draw")) {
                break;
            }
        }

        socket.close();
        System.out.println("Connessione chiusa.");
    }
}

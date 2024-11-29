import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendObjectOutputStream extends ObjectOutputStream {

	//                                             passo la gestione delle eccezioni con THROWS 
	public AppendObjectOutputStream(OutputStream out) throws IOException{
		super(out);
	}

	protected void writeStreamHeader() throws IOException{
		// Evita di riscrivere l'intestazione 
		// non fa nulla 
		// questo metodo viene ricritto... vuoto - non fa nulla
		System.out.println("Sono in writeStreamHeader");
	}
}

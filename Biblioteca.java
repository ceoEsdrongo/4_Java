/**
 * Leggi file appena avviato programma
 * Salvare un libro in nel file ogni volta ceh viene aggiunto
 */

package BibliotecaFileOggetti;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	private String nome;
	private int NUM_MAX;
	private ArrayList<Libro> Biblioteca;
	private Libro libro;
	private final int DIM_ISBN=13;

	public Biblioteca() {
		Biblioteca=new ArrayList<Libro>(3);
	}

	public void insDati() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Inserisci nome biblioteca");
		this.nome=sc.nextLine();
	}

	public void inserimento() {
		libro=new Libro();
		libro.insISBN();
		libro.insTitolo();
		libro.insAutore();
		libro.insArgomento();
		libro.insPrezzo();
		if(Biblioteca.isEmpty())
			Biblioteca.add(libro);
		else {
			controlloUnico(libro);
			if(!libro.getISBN().equalsIgnoreCase("Errore"))
				Biblioteca.add(libro);
			else {
				System.out.println("Libro non inserito, ISBN uguale a libro già presente");
			}

		}

	}

	public void visualizza() {
		if(!Biblioteca.isEmpty()) {
			for(int i=0;i<Biblioteca.size();i++) {
				System.out.println("\nBiblioteca: "+nome);
				Biblioteca.get(i).visualizza();
			}
		}else
			System.out.println("Non sono presenti libri");
	}

	public void ricercaISBN() {
		Scanner sc = new Scanner(System.in);
		String isbn;
		System.out.println("Inserisci ISBN");
		isbn=sc.nextLine();
		while(isbn.length()!=DIM_ISBN) {
			System.out.println("Re-inserisci ISBN");
			isbn=sc.nextLine();
		}
		boolean trovato=false;
		for(int i=0;i<Biblioteca.size();i++) {
			if(Biblioteca.get(i).getISBN().equalsIgnoreCase(isbn)) {
				System.out.println("\nBiblioteca: "+nome);
				Biblioteca.get(i).visualizza();;
				trovato=true;
				break;
			}
		}
		if(!trovato)
			System.out.println("Libro non trovato");
	}

	public void visualizzaAutore() {
		Scanner sc=new Scanner(System.in);
		if(!Biblioteca.isEmpty()) {
			System.out.println("Inserisci titolo del libro:");
			String titolo=sc.nextLine();
			boolean trovato=false;
			int i=0;
			while(!trovato && i<Biblioteca.size()) {
				if(Biblioteca.get(i).getTitolo().equalsIgnoreCase(titolo)) {
					Biblioteca.get(i).VisAutore();
					trovato=true;
				}else
					i++;
			}
			if(!trovato)
				System.out.println("Non è stato trovato il libro");
		}else
			System.out.println("Non sono presenti libri");
	}

	public void visualizzaConRange() {
		Scanner sc=new Scanner(System.in);
		if(!Biblioteca.isEmpty()) {
			int min = 0;
			int max = 0;
			boolean errore = true;
			do {
				try {
					System.out.println("Inserisci prezzo minimo");
					min = sc.nextInt();
					if(min<0){
						System.out.println("Il prezzo minimo deve essere maggiore o uguale a 0");
					}
					errore = false;
				} catch (Exception e) {
					System.out.println("Dato inserito non corretto");
					sc.nextLine();
				}
			}while(errore || min<0);

			boolean error=true;
			do {
				try {
					System.out.println("Inserisci prezzo minimo");
					max = sc.nextInt();
					if(max<0){
						System.out.println("Il prezzo minimo deve essere maggiore o uguale a 0");
					}
					error = false;
				} catch (Exception e) {
					System.out.println("Dato inserito non corretto");
					sc.nextLine();
				}
			}while(error || max<0);
			boolean trovato=false;
			for(int i=0;i<Biblioteca.size();i++) {
				if(Biblioteca.get(i).getPrezzo()<=max && Biblioteca.get(i).getPrezzo()>=min) {
					Biblioteca.get(i).visualizza();
					trovato=true;
				}
			}
			if(!trovato)
				System.out.println("Non sono presenti libri in questo range di prezzi");
		}else
			System.out.println("Non sono presenti libri");
	}

	public void visualizzaArgomento() {
		Scanner sc=new Scanner(System.in);
		if(!Biblioteca.isEmpty()) {
			System.out.println("Inserisci argomento che si sta cercando:");
			String argomento=sc.nextLine();
			boolean trovato=false;
			for(int i=0;i<Biblioteca.size();i++) {
				if(Biblioteca.get(i).getArgomento().equalsIgnoreCase(argomento)) {
					Biblioteca.get(i).VisTitolo();
					trovato=true;
				}
			}
			if(!trovato)
				System.out.println("Non sono presenti libri con questo argomento");
		}else
			System.out.println("Non sono presenti libri");
	}

	public void visualizzaLibroCostoso() {
		double max=0;
		for(int i=0;i<Biblioteca.size();i++) {
			if(max<Biblioteca.get(i).getPrezzo()) {
				max=Biblioteca.get(i).getPrezzo();
			}
		}
		for(int i=0;i<Biblioteca.size();i++) {
			if(max==Biblioteca.get(i).getPrezzo()) {
				Biblioteca.get(i).visualizza();
			}
		}
	}

	public void aggiornamento() {
		Scanner sc=new Scanner(System.in);
		String isbn;
		System.out.println("Inserisci isbn da cercare");
		isbn=sc.nextLine();
		while(isbn.length()!=DIM_ISBN) {
			System.out.println("Re-inserisci ISBN");
			isbn=sc.nextLine();
		}
		boolean trovato=false;
		int i=0;
		while(!trovato && i<Biblioteca.size()) {
			if(Biblioteca.get(i).getISBN().equalsIgnoreCase(isbn)) {
				System.out.println("Inserisci ISBN nuovo libro");
				String Isbn=sc.nextLine();
				for (int k=0;k<Biblioteca.size();k++) {
					if(k!=i) {
						controlloUnico(libro);
						if (!libro.getISBN().equalsIgnoreCase("Errore")) {
							Biblioteca.add(libro);
						}
					}
				}
				System.out.println("Inserisci nome dell'autore nuovo");
				String aggiornamentoAutore=sc.nextLine();
				System.out.println("Inserisci titolo del nuovo libro");
				String aggiornamentoTitolo=sc.nextLine();
				System.out.println("Inserisci argomento del nuovo libro");
				String aggiornamentoArgomento=sc.nextLine();
				int aggiornamentoPrezzo=0;
				boolean errore = true;
				do {
					try {
						System.out.println("Inserisci prezzo del nuovo libro");
						aggiornamentoPrezzo = sc.nextInt();
						if(aggiornamentoPrezzo < 0){
							System.out.println("Prezzo inserito maggiore o uguale a zero");
						}
						errore = false;
					} catch (Exception e) {
						System.out.println("Dato inserito errato");
						sc.nextLine();
					}
				}while(errore || aggiornamentoPrezzo<0);
				Biblioteca.get(i).setArgomento(aggiornamentoArgomento);
				Biblioteca.get(i).setAutore(aggiornamentoAutore);
				Biblioteca.get(i).setISBN(Isbn);
				Biblioteca.get(i).setTitolo(aggiornamentoTitolo);
				Biblioteca.get(i).setPrezzo(aggiornamentoPrezzo);
			}else
				i++;
		}
	}

	public void eliminazione() {
		Scanner sc=new Scanner(System.in);
		String isbn;
		System.out.println("Inserisci isbn del libro da elimare");
		isbn=sc.nextLine();
		while(isbn.length()!=DIM_ISBN) {
			System.out.println("Re-inserisci ISBN");
			isbn=sc.nextLine();
		}
		boolean trovato=false;
		int i=0;
		while(!trovato && i<Biblioteca.size()) {
			if(Biblioteca.get(i).getISBN().equalsIgnoreCase(isbn)) {
				Biblioteca.remove(i);
				//				Biblioteca.trimToSize();
				trovato=true;
			}else
				i++;
		}
		if(trovato)
			System.out.println("Libro eliminato");
		else
			System.out.println("Libro non trovato");
	}

	public String getNome() {
		return nome;
	}

	//Controllo unicità di un codice ISBN
	public void controlloUnico(Libro l) {
		for(int j=Biblioteca.size()-1;j>=0;j--){
			if(l.getISBN().equalsIgnoreCase(Biblioteca.get(j).getISBN())) {
				l.setISBN("Errore");
			}
		}
	}

	public void eliminazioneFile(){
		Scanner sc = new Scanner(System.in);
		File nomeFile = new File("Biblioteca.dat");
		int NUM_SICUREZZA = 2;
		String scelta;
		if(nomeFile.exists()){
			for(int i = 0; i < NUM_SICUREZZA; i++){
				do{
					System.out.println("Vuoi eliminare il file? Una volta eliminato sarà irrecuperabile\n[S/N]");
					scelta = sc.nextLine();
				}while(!scelta.toUpperCase().equals("S") && !scelta.toUpperCase().equals("N"));
				if(scelta.toUpperCase().equals("N")){
					return;
				}
			}
			if(nomeFile.delete())
				System.out.println("File eliminato");
			else
				System.out.println("File non eliminato correttamente");
		}else
			System.out.println("File non esistente");
	}

	public void salvataggio() {
		if(!Biblioteca.isEmpty()) {
			try {
				File nomeFile = new File("Biblioteca.dat");
//				boolean fileEsiste = nomeFile.exists();
				FileOutputStream fos = new FileOutputStream(nomeFile);
				ObjectOutputStream oos;
				
				oos = new ObjectOutputStream(fos);
				
				
				oos.writeObject(Biblioteca);
				
				oos.flush();

				oos.close();
				fos.close();
			} catch (IOException e) {
				System.out.println("Errore");
				System.out.println(e);
			}

		}else System.out.println("Non sono stati salvati libri");
	}

	
	public void leggiFile(){
		File nomeFile = new File("Biblioteca.dat");
		FileInputStream fin;
		ObjectInputStream ois;
		if(!nomeFile.exists()){
			System.out.println("File non esistente");
		}else {
			try {
				fin = new FileInputStream(nomeFile);
				ois = new ObjectInputStream(fin);
				
				Biblioteca = (ArrayList<Libro>) ois.readObject();
					
				
				ois.close();
				fin.close();
			} catch (Exception e) {
				System.out.println("Errore");
				e.printStackTrace();
			}
			
		}
	}
}

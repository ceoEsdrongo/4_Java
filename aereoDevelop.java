import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Passeggero p = new Passeggero();
        p.inserisci();
        p.visualizza();
        

    }
}

------------------------
  Passeggero.java
 import java.util.Scanner;

public class Passeggero {
    private final int costoBase; //biglietto
    private String nome, cognome;
    private int pesoMano;
    private int pesoStiva;
    final int costoBaseBagaglioMano=10,pesoBagaglioMano=10,costoMaggBagaglioMano=2,costoBaseBagaglioStiva=30,pesoBaseBagaglioStiva=20,costoMaggBagaglioStiva=5;

    //costruttore
    public Passeggero() {
        nome = "";
        cognome = "";
        pesoMano = 0;
        pesoStiva = 0;
        costoBase = 50;
    }

    public Passeggero(String nome, String cognome, int pesoMano, int pesoStiva, int costoBase) {
        this.nome = nome;
        this.cognome = cognome;
        this.pesoMano = pesoMano;
        this.pesoStiva = pesoStiva;
        this.costoBase = 50;
    }

    //get
    public String getNome() {
        return nome;
    }

    //set
    public void setNome(String nome) {
        //eventuali controlli
        this.nome = nome;
    }
    //sovrascrive il comportamento di tutti gli oggetti di tipo Passeggero

                                /*public String toString(){
                                    return "ciao";
                                }*/

    public void inserisci() {
        Scanner sc = new Scanner(System.in);
        System.out.println("inserisci il nome");
        nome = sc.nextLine();
        System.out.println("inserisci il cognome");
        cognome = sc.nextLine();
        System.out.println("inserisci il peso bagaglio mano");
        pesoMano = sc.nextInt();
        sc.nextLine();
        System.out.println("inserisci il peso bagaglio stiva");
        pesoStiva = sc.nextInt();
        sc.nextLine();
    }
    /*public void visualizza(){

    }*/

    @Override
    public String toString() {
        return "Passeggero{" + "nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", pesoMano=" + pesoMano + ", pesoStiva=" + pesoStiva + ", costoBase=" + costoBase + '}';
    }
    public void visualizza(){
        System.out.println(this.toString());
    }
    public int getCostoBiglietto(){
        int c=costoBase;
        
        c+=costoBaseBagaglioMano;
        if(pesoMano>=pesoBagaglioMano) {
            c += (pesoMano - pesoBagaglioMano) * costoMaggBagaglioMano;
        }
        c+=costoBaseBagaglioStiva;
        if(pesoStiva>pesoBaseBagaglioStiva){
            c+=(pesoStiva-pesoBaseBagaglioStiva)*costoMaggBagaglioStiva;
        }
        return c;
    }
}

---------------------
    Aereo.java
    






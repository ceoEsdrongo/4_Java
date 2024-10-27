import java.util.Vector;

/*Si vogliono memorizzare le informazioni dei libri della biblioteca dell'Euganeo riportando,
per ogni libro, il codice ISBN (codice univoco), il titolo, l’autore, l’argomento e il prezzo.
Realizzare la classe Libro con quanto richiesto.
Creare la classe Biblioteca con il nome della biblioteca e il numero max di libri presenti.
Sviluppare le funzionalità CRUD (controllare che i codici ISBN siano univoci, aggiungere i
controlli opportuni e try-catch,…) per risolvere i seguenti punti:
1. creare una biblioteca con un certo nome e un numero massimo di libri
2. inserire dei libri nella biblioteca, uno alla volta controllando l’univocità del codice
ISBN
3. visualizzare
a. tutta la biblioteca
b. visualizzare le informazioni di un libro dato un codice ISBN
c. visualizzare l'autore del libro di un certo titolo
d. visualizzare l’elenco dei libri che hanno un prezzo compreso tra un min e max
e. visualizzare l’elenco dei libri di un certo argomento
f. visualizzare il titolo dei libri che hanno il prezzo più alto
4. aggiornare le informazioni di un libro dato il suo ISBN
5. cancellare un libro dato il suo ISBN*/
public class Scaffale {
   private String nome;
   private Vector<Libro>targa;

   public Scaffale(String nome){
       this.nome=nome;
       targa=new Vector<Libro>();
   }
   public void inserimento(Libro l){
       for(Libro book:targa){
           if(book.getISBN().equals(l.getISBN())){
               System.out.println("");
           }
       }
       targa.add(l);
   }
   public void visualizza(){
       if(targa.isEmpty()){
           System.out.println("");
       }
       else {
           for (Libro l : targa) {
               System.out.println(l);
           }
       }
   }
   public void visualizzaISBN(String isbn){
       for(Libro l1:targa){
           if(l1.getISBN().equals(isbn)){
               System.out.println(l1);
           }
       }

   }
   public void visualizzaAutore(String titolo){
       for (Libro l:targa){
           if(l.getAutore().equalsIgnoreCase(titolo)){
               System.out.println(l+"titolo");
           }
       }
   }
   public void visualizzaRange(double min, double max){
       boolean t=false;
       for (Libro l:targa){
           if(l.getPrezzo()>min&&l.getPrezzo()<max){
               System.out.println(l);
               t=true;
           }
       }
   }
   public void argomento(String argomento){
       boolean t=true;
       for (Libro l:targa){
           if(l.getArgomento().equalsIgnoreCase(argomento)){
               System.out.println(l);
               t=false;
           }
       }
   }
   public void prezzoMax(){
       for (Libro l:targa){
           if(targa.isEmpty()){
               System.out.println();
           }

       }
       double maxPrezzo=0;
       String valMassimo="";
       for(Libro l:targa){
           if(l.getPrezzo()>maxPrezzo){
               maxPrezzo=l.getPrezzo();
               valMassimo=l.getTitolo();
           }
       }
       System.out.println("il valore massimo del libro0"+valMassimo+"costa"+maxPrezzo);
   }
   public void cancellaLibro(String isbn){
       for (int i = 0; i < targa.size(); i++) {
           if(targa.get(i).getISBN().equals(isbn)){
               targa.remove(i);
           }
       }
   }
    public void aggiornaLibro(String isbn) {
        for (Libro l : targa) {
            if (l.getISBN().equals(isbn)) {
                System.out.println("Inserisci le nuove informazioni del libro:");
                l.inserimento();
                System.out.println("Libro aggiornato con successo!");
                return;
            }
        }
        System.out.println("Libro con ISBN " + isbn + " non trovato.");
    }
}

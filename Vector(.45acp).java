----------TestVector
  import java.util.Vector;


public class TestVector {
    public static void main(String[] args) {
        Vector<Quadrato> v =new Vector<Quadrato>();
        System.out.println("Size = "+v.size());
        System.out.println("Capacity = "+v.capacity());
        /*Quadrato q = new Quadrato(3);
        v.add(q);
        System.out.println("Size = "+v.size());
        System.out.println("Capacity = "+v.capacity());*/
        for (int i = 1; i <=10 ; i++) {
            Quadrato q = new Quadrato(i);
            v.add(q);
        }
        /*System.out.println("Size = "+v.size());
        System.out.println("Capacity = "+v.capacity());*/
        Quadrato q1 = new Quadrato(11);
        v.add(q1);
        System.out.println("Size = "+v.size());
        System.out.println("Capacity = "+v.capacity());
        v.remove(0);
        v.remove(1);
        v.remove(2);
        for (int i = 0; i < v.size(); i++) {
            v.get(i).visualizza();
        }
    }
}


}


-------------------Quadrato
  public class Quadrato {
    private int lato;
    public Quadrato(int lato){
        this.lato=lato;
    }
    public void visualizza(){
        System.out.println("quadrato");
    }

}

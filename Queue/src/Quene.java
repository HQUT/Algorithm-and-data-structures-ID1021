import java.util.Random;

public class Quene {
    public static Node last, front ;
    int length;
    public class Node {
        public Integer item;
        public Node next;
        public Node(Integer item ){
            this.item = item;
            this.next = null;
        }
    }
    public Quene() {
      this.front = null;
      this.last = null;
      length = 0;
    }
    public void enquene(Integer item) {
    Node nod = new Node (item);
        System.out.printf("Inserting %d\n", item);
    if (front == null){
        front =nod;
        last = nod;
    }
    else{
        last.next = nod;
        last = nod;

    }

  length+=1;
    }
    public boolean isEmpty(){
        return (front== null);
    }
   public Integer dequeue() {
   if(isEmpty()){
       System.out.println("\n the quene is empty, nothing to delete :(, :(");
       System.exit(-1);
   }
    Node temp= front;
   System.out.println(" Removing \n" + temp.item);
    front = front.next;
   if(isEmpty()) {
       last = null;
   }
    length -=1;
   return temp.item;
   }

    public static void main(String[] args){

        Quene quene=new Quene();
        Random rnd= new Random();
        int k=10240;
        double min1 = Double.POSITIVE_INFINITY;
        for( int j=0; j<1000; j++) {
            long t0 = System.nanoTime();
            for (int i = 0; i < k; i++) {
                quene.enquene(rnd.nextInt(100));
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min1)
                    min1 = t;
            }
        }
        double min2 = Double.POSITIVE_INFINITY;
        for(int j=0 ; j<1000 ;j++) {
            long t2 = System.nanoTime();
            for (int i = 0; i < k; i++) {
                quene.dequeue();
                long t3 = System.nanoTime();
                double t1 = (t3 - t2);
                if (t1 < min2)
                    min2 = t1;
            }
        }
        double t_enqeue=(min1/1000);
        double t_deqeue=(min2/1000);
        System.out.printf("%8.5f\n" , t_enqeue);
        System.out.printf("%8.5f\n" , t_deqeue);
    }
}

import java.util.Random;
public class Quene_op {
    public static node last, front ;
    int length;
    public class node {
        public Integer item;
        public node next;
        public node(Integer item ){
            this.item = item;
            this.next = null;
        }
    }

    public Quene_op() {
        this.front = null;
        this.last = null;
        length = 0;
    }
    public void enquene(Integer item) {
      node nod = new node(item);
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
    public Integer dequeue() {
        if(isEmpty()){
            System.out.println("\n the quene is empty, nothin to delete :(:(");
            System.exit(-1);
        }
        node prev = null;
        node current = front;
        while (current.next != null){
            prev = current;
            current = current.next;
        }
        if (prev == null)
            front=null;
        else prev.next = null;
        return current.item;
    }
    public boolean isEmpty(){
        return (front == null);
    }

    public static void main(String[] args){
        Quene_op q=new Quene_op();
        Random rnd= new Random();
        int k=10;
       double min1 = Double.POSITIVE_INFINITY;
        for( int j=0; j<1000; j++) {
            long t0 = System.nanoTime();
            for (int i = 0; i < k; i++) {
                q.enquene(rnd.nextInt(100));
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
                q.dequeue();
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

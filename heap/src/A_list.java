import java.util.Random;

public class A_list {
    public Node first;

    class Node {
        public Integer item;
        public Node next;

        public Integer priority;

        public Node(Integer prio, Integer item, Node next) {
            this.priority =prio;
            this.item= item;
            this.next=next;
        }
    }

     public A_list(){
        this.first = null;
     }

    public void print() {
        if (this.first == null) {
            System.out.println("print(): queue is empty");
            return;
        }
        Node list = first;
        while (list.next != null) {
            System.out.print("[" + list.priority + "] ");
            list = list.next;
        }
        System.out.print("[" + list.priority + "]");
    }






    public void enquene(Integer prio, Integer item) {
        Node prev = null;
        Node curr = first;
       while(curr != null && prio.compareTo(curr.priority)>0) {
           prev = curr;
           curr = curr.next;
        }
       if(prev == null) {
           first = new Node(prio, item, first);
       }
       else {
           prev.next = new Node(prio, item, curr);
       }
    }
    Integer peek(){
        if(isEmpty()) {
            System.out.println("No peek element");
            return null;
        }
      return first.item;
    }
    public boolean isEmpty(){
      return (first == null);
    }


    public Integer dequeue() {

        if(isEmpty()) {
            return null;
        }
        Node temp = first;

       first= first.next;
      // System.out.println( temp.priority);

        return temp.priority;
    }

    public static void main(String [] args){
       A_list q= new A_list();
       Random rnd= new Random();
       int k= 2560;

        double min1=Double.POSITIVE_INFINITY;
        double max1=0;
        double ti =0;
       System.out.println("\n the list: ");
       for(int j=0; j<100;j++)
           for(int i= 0; i<k; i++) {
           int item = rnd.nextInt(100);
           int prio = rnd.nextInt(100);
           long t0 = System.nanoTime();
               q.enquene(prio, item);
               long t1 = System.nanoTime();
               double t = (t1 - t0);
               ti += t;
           }

     //  q.print();
        System.out.println("\n the time it takes to add : " + (ti/(k*1000)));

        System.out.println("\n removed: " );
        double min2=Double.POSITIVE_INFINITY;
        for (int i=0; i<k; i++){
            long t2= System.nanoTime();
            q.dequeue();
            long t3 = System.nanoTime();
            double t4 = (t3 - t2);
            if (t4 < min2)
                min2 = t4;
        }
       // q.print();
        System.out.println("\n the time it takes to remove : "+ min2 );




    }
}





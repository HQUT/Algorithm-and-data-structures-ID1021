import java.util.Random;
public class ListQueue {
    public Node first;
    public Node last;

    private class Node {
        private int item;
        private Node next;

        public Node(int item, Node nxt) {
            this.item = item;
            this.next = nxt;
        }
    }
    public ListQueue() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }
        public void add(int item) {
            Node newNode = new Node(item, null);
            if (this.first == null)
                this.first = newNode;
            if (this.last != null)
                this.last.next = newNode;
            this.last = newNode;
        }


        public int remove() {
            Node list = first;
            Node previous = null;
            Node min = first;

            while (list.next != null) {
                if (list.next.item < min.item) {
                    previous = list;
                    min = list.next;
                }
                list = list.next;
            }

            if (min.item == first.item) {
                first = first.next;
            }
            else{
                previous.next = min.next;
            }
          //  System.out.println("\n the removed item is :" +min.item);

            return min.item;
        }


    public void print() {
        if (this.first == null) {
            System.out.println("print(): queue is empty");
            return;
        }
        Node current = this.first;
        System.out.println("start of queue");
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ListQueue queue = new ListQueue();
        Random rnd = new Random();
        int k= 2560;
        double ti=0;
        double min1=Double.POSITIVE_INFINITY;
        for(int i= 0; i<k*100; i++) {
            long t0 = System.nanoTime();
                queue.add(rnd.nextInt(100));
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min1)
                    min1 = t;
            }

        //queue.print();
        System.out.println("\n the time it takes to add : "+ min1);

        System.out.println("\n removed: " );
        double min2=Double.POSITIVE_INFINITY;
        for(int j=0;j<100;j++)
            for (int i=0; i<k; i++){
            long t2= System.nanoTime();
             queue.remove();
            long t3 = System.nanoTime();
            double t4 = (t3 - t2);
            ti += t4;

        }
       //queue.print();
        System.out.println("\n the time it takes to remove : "+ ti/(k*100 ));

    }

}
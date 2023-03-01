import java.util.NoSuchElementException;
import java.util.Random;
public class doubleLinkedLista {
    static nod head;
    int size;

    public doubleLinkedLista() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        if (this.size == 0)
            return true;
        else return false;
    }

    public void dispaly() {
        nod n = head;
        while (n != null) {
            System.out.print(n.data + "<=>");
            n = n.next;
        }
    }

    public void addFront(int data) {
        if (head == null)
            head = new nod(null, data, null);
        else {
            nod newNod = new nod(null, data, head);
            head.previous = newNod;
            head = newNod;
        }
        size++;
    }

    public void addBack(int data) {
        if (head == null)
            head = new nod(null, data, null);
        else {
            nod actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            nod newNod = new nod(actual, data, null);
            actual.next = newNod;
            // kan ej vara en head
            // actual = newNod;

        }

    }

    public void removeFront() {
        if (head == null)
            return;

        head = head.next;
        head.previous = null;
        size--;
    }

    public void removeBack() {
        if (isEmpty())
            System.out.println("List is Empty :( :(");

        if (head.next == null) {
            head = null;
            size--;
        }
        nod actual = head;
        while (actual.next.next != null) {
            actual = actual.next;
        }
        actual.next = null;
        size--;
    }
    /*public void removeAt(int index){
        if (head == null)
            return;
        if (index<0 || index >size)
        return;

        nod actual= head;
        int i = 1;
        while (i< index){
            actual = actual.next;
            i++;
        }
        if( actual.next == null){
            actual.previous.next = null;
        }
        else if(actual.previous == null){
            actual = actual.next;
            actual.previous = null;
            head = actual;
        }
        else{
            actual.previous.next = actual.next;
            actual.next.previous = actual.previous;
        }
        size--;

    }*/
    public void removeAt(int value) {

        if (isEmpty())
            throw new NoSuchElementException();


        if (value < 0 || value > size)
            return;

        nod temp = head;
        for (int i = 1; i < value; i++) {
            temp = temp.next;


            if (temp.next == null) {
                temp.previous.next = null;

            } else if (temp.previous == null) {
                temp = temp.next;
                temp.previous = null;
                head = temp;

            } else {
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;

            }
            size--;

        }
    }



    public int findNodeAt(int location) {
       nod node = this.head;
        if(head !=null && location<= size){
            for(int i=1;i<location;i++){
                node = node.next;
            }
           System.out.println("DListNode item at location "+location+" is "+node.data);
        }
        return node.data;
    }



    public static void main(String[] args) {
        doubleLinkedLista dll = new doubleLinkedLista();
        Random rnd = new Random();
        int k = 80;
        int n = 5;
        int[] sequence = new int[k];
        for (int i = 0; i < k; i++) {
            sequence[i] = rnd.nextInt(n);
            System.out.print(sequence[i] + ";");
        }

        for ( int i= 0; i<n; i++){
            int random_data= rnd.nextInt(100);
            dll.addFront(random_data);
        }
        System.out.print( "\n");
        dll.dispaly();

        double min = Double.POSITIVE_INFINITY;
        for (int i= 0; i<k; i++) {
            int index = sequence[i];
            System.out.print( "\n");
            int s=dll.findNodeAt(index);
            long t0 = System.nanoTime();
            dll.removeAt(index);
           System.out.println("\nEfter remove objekt at position: "+index);
          dll.dispaly();
           // dll.addFront(s);
           //System.out.println("\nEfter adding back the objekt  ");
           // dll.dispaly();

            long t1 = System.nanoTime();
            double t_access = (t1 - t0);

            if (t_access < min)
                min = t_access;
        }
        double t= min/(1000);
        double t1= (min/(1000))/n;
        System.out.printf("\n %8.5f ",t);
        System.out.printf("\n %8.5f ",t1);


    }
}



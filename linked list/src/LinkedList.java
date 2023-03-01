import java.util.Random;

public class LinkedList {
    Node head;
    int size;
    LinkedList tail;




    public LinkedList() {

    }

    public Node head() {
        return this.head;
    }
    public LinkedList tail() {
        return this.tail;
    }
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if(this.size == 0) return true;
        else return false;
    }
    public void removeFirst(){
        if (head == null)
            return;

        head = head.next;
        size--;
    }

    public void removeLast(){
        System.out.println("List is Empty :( :(");

        if (head.next == null) {
            head = null;
            size--;
        }
        Node actual = head;
        while (actual.next.next != null) {
            actual = actual.next;
        }
        actual.next = null;
        size--;
    }
    public void add(Node newNode) {
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addFront(int data) {
        if (head == null)
            head = new Node( data, null);
        else {
            Node newNod = new Node( data, head);
            head = newNod;
        }
        size++;
    }
    public void removeAt(int index ) {

        if (head == null)
            return;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (index == 0) {
            head = temp.next; // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < index- 1;
             i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next
                = next; // Unlink the deleted node from list
    }





    public int findNodeAt(int location) {
        Node node = this.head;
        if(head !=null && location<= size){
            for(int i=0;i<location;i++){
                node = node.next;
            }
            System.out.println("DListNode item at location "+location+" is "+node.value);
        }
        return node.value;
    }


    public  void append(LinkedList a) {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = a.head;

        }

    public void display(){
        Node n = head;
        while(n != null){
            System.out.println(n.value);
            n = n.next;
        }
    }
    public static void main(String[] args) {
        Random rnd = new Random();
        LinkedList ls = new LinkedList();

        int k = 1000;
        int n = 40;
        int[] sequence = new int[k];
        for (int i = 0; i < k; i++) {
            sequence[i] = rnd.nextInt(n);
            System.out.print(sequence[i] + ";");
        }


        for ( int i= 0; i<n; i++){
            int random_data= rnd.nextInt(100);
            ls.addFront(random_data);
        }
        System.out.print( "\n");
        ls.display();
        double min = Double.POSITIVE_INFINITY;
        for (int i= 0; i<k; i++) {
            int index = sequence[i];
            System.out.print( "\n");
            int s=ls.findNodeAt(index);
            long t0 = System.nanoTime();
            ls.removeAt(index);
           // System.out.println("\nEfter remove objekt at position: "+index);
            // ls.display();
            ls.addFront(s);
           // System.out.println("\nEfter adding back the objekt  ");
            //ls.display();

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
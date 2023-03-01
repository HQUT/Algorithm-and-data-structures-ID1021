
/*public class Linked_list {
    public class Node {
        public Node next;
        public int value;

        public  Node(int value) {
            this.value = value;
        }
    }

        Node head;

        public Linked_list() {
            head = null;
        }


    void add(int data)
    {
        if (head == null)
        {
            head = new Node(data);
            return;
        }

        Node curr = head;
        while (curr.next != null)
            curr = curr.next;

        Node newNode = new Node(data);
        curr.next = newNode;
    }

    void print(Node n)
    {
        while (n != null)
        {
            System.out.print(n.value);
            System.out.print(" ");
            n = n.next;
        }
    }

    Node partition(Node low, Node high)
    {
        if (low == high || low == null || high == null)
            return low;
        Node pivot_prev = low;
        Node actual = low;
        int pivot = high.value;

        while (low != high) {
            if (low.value < pivot) {
                pivot_prev = actual;
                int temp = actual.value;
                actual.value = low.value;
                low.value = temp;
                actual = actual.next;
            }
            low = low.next;
        }

        int temp = actual.value;
        actual.value = pivot;
       high.value = temp;

        return pivot_prev;
    }

    void sort(Node low, Node high)
    {
        if(low == null || low == high|| low == high.next )
            return;

        Node pivot = partition(low, high);
        sort(low, pivot);

        if (pivot!= null && pivot == low)
            sort(pivot.next, high);
        else if (pivot != null
                && pivot.next != null)
            sort(pivot.next.next, high);
    }

    }*/

public class Linked_list {
    static class Node {

        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    Node head;

    void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node curr = head;
        while (curr.next != null)
            curr = curr.next;

        Node newNode = new Node(data);
        curr.next = newNode;
    }

    void printList(Node n) {
        while (n != null) {
            System.out.print(n.data);
            System.out.print(" ");
            n = n.next;
        }
    }

    // Takes first and last node,
    // but do not break any links in
    // the whole linked list
    Node paritionLast(Node start, Node end) {
        if (start == end || start == null || end == null)
            return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.data < pivot) {

                // keep tracks of last modified item
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        // Swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;

        // Return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    void sort(Node start, Node end) {
        if (start == null || start == end
                || start == end.next)
            return;

        // Split list and partition recurse
        Node pivot_prev = paritionLast(start, end);
        sort(start, pivot_prev);

        // If pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);

            // If pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }
}
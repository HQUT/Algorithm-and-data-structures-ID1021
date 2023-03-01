import java.util.Iterator;
import java.util.*;

public class BinaryTree implements Iterable<Integer> {
    public static Node root;

    public class Node {
        public Integer key;
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }



        private void add(Integer k, Integer v) {
            if (this.key == k)
                this.value = v;

            if (this.key > k) {
                if (this.left == null) {
                    this.left = new Node(k, v);
                } else {
                    this.left.add(k, v);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(k, v);
                } else {
                    this.right.add(k, v);
                }
            }
        }

        private Node promote() {
            if (this.left == null)
                return this;
            Node current = this;
            while (current.left.left != null) {
                current = current.left;
            }
            Node ge_mig = current.left;
            current.left = current.left.right;
            ge_mig.right = this;
            return ge_mig;
        }

        private Node delete(Integer k) {
            if (this.key == k) {
                if (this.left == null)
                    return this.right;
                if (this.right == null)
                    return this.left;
                Node promoted = this.right.promote();
                promoted.left = this.left;
                return promoted;
            }
            if (this.key < k && this.right != null) {
                Node deleted = this.right.delete(k);
                this.right = deleted;
                return this;
            }
            if (this.key > k && this.left != null) {
                Node deleted = this.left.delete(k);
                this.left = deleted;
                return this;
            }
            return this;
        }

        public void print() {
            if (left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if (right != null)
                right.print();
        }

    }

    public BinaryTree() {
        root = null;
    }

    public void add(Integer k, Integer v) {
        if (root == null)
            root = new Node(k, v);
        else
            root.add(k, v);
    }


    public int lookup(Integer key) {
        Node current = this.root;
        while (current != null) {
            if (current.key == key)
                System.out.println("The value at key: " + key + " is " + current.value);

            if (current.key < key)
                current = current.right;
            else
                current = current.left;
        }
        return -1;
    }


    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    public class TreeIterator implements Iterator<Integer> {
        //    private BinaryTree.Node next;
        private Quene stack;
        public TreeIterator() {
            stack = new Quene(BinaryTree.root);
        }

        @Override
        public boolean hasNext() {
            return stack.root != null;
        }

        @Override
        public Integer next() {
            if (hasNext() == false)
                return null;
            BinaryTree.Node current  = stack.root.item;
            int tbr = current.value;
            if(current.left != null) {stack.enqueue(current.left);}
            if(current.right != null) {stack.enqueue(current.right);}
            stack.dequeue();
            return tbr;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }



    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Random rnd = new Random();
        int k = 10;
        int[] sequance = new int[k];
        for (int i = 0; i < k; i++) {
            sequance[i] = rnd.nextInt(500);
            //System.out.println(sequance[i]);
        }
        int n = 10;
        int random_key;
        for (int i = 0; i < n; i++) {
            random_key = sequance[i];
            tree.add(random_key, rnd.nextInt(500));
        }

        tree.root.print();
       // tree.root.breathFirstTraversal();
        tree.add(5, 105);
        tree.add(2, 102);
        tree.add(7, 107);
        tree.add(1, 101);
        tree.add(8, 108);
        tree.add(6, 106);
        tree.add(3, 103);

   for (Integer item : tree) {
            System.out.println(" next value " + item);
        }

    }

    class Quene {
        public Node first;
        public Node last;
        public int n;


        public static class Node {
            private Integer item;
            private Node next;

            Node(Integer n) {
                item = n;
            }
        }


        public Quene(BinaryTree.Node root) {
            first = null;
            last = null;
            n = 0;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return n;
        }

        public void enqueue(BinaryTree.Node item) {

            Node nod = new Node(item);
            System.out.printf("Inserting %d\n", item);
            if (first == null) {
                first = nod;
                last = nod;
            } else {
                last.next = nod;
                last = nod;

            }
            n += 1;
        }

        public Integer dequeue() {
            if (isEmpty()) {
                System.out.println("\n the quene is empty, nothin to delete :(, :(");
                System.exit(-1);
            }
            Node temp = first;
            System.out.println(" Removing \n" + temp.item);
            first = first.next;
            if (isEmpty()) {
                last = null;
            }
            n -= 1;
            return temp.item;
        }
    }
}
import java.util.Iterator;
import java.util.Random;

public class binaryTree {

    Node root;
    Integer value;

    public binaryTree() {
       root = null;
    }



    public class Node {

        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;

        }


        private void inOrder(Node node) {

            if (node == null) {
                return;
            }

            inOrder(node.left);

            System.out.printf("%s ", node.value);

            inOrder(node.right);

        }
        public void inOrder() {

            inOrder(root);

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

        public void print() {
            if (left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if (right != null)
                right.print();
        }

        private Node promote(){
            if( this.left == null)
                return this;
            Node current = this;
            while (current.left.left != null){
                current = current.left;
            }
            Node ge_mig = current.left;
            current.left = current.left.right;
            ge_mig.right = this;
            return ge_mig;
        }

        private Node delete(Integer k){
            if(this.key == k){
                if(this.left == null)
                    return this.right;
                if(this.right == null)
                    return this.left;
                Node promoted = this.right.promote();
                promoted.left = this.left;
                return promoted;
            }
            if(this.key < k && this.right != null){
                Node deleted = this.right.delete(k);
                this.right = deleted;
                return this;
            }
            if(this.key > k && this.left != null){
                Node deleted = this.left.delete(k);
                this.left= deleted;
                return this;
            }
            return this;
        }
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
                System.out.println("The value at key: " + key +" is " +current.value);

            if (current.key < key)
                current = current.right;
            else
                current = current.left;
        }
        return -1;
    }






    public static void main(String[] args) {
        binaryTree tree = new binaryTree();
        Random rnd=new Random();
        int k=100000;
        int [] sequance=new int[k];
        for(int i=0; i<k; i++){
            sequance[i]= rnd.nextInt(1000);
            //System.out.println(sequance[i]);
        }
        int n= 1000;
        int random_key;
        for (int i= 0; i<n; i++){
            random_key=sequance[i];
            tree.add(random_key, rnd.nextInt(10000));
        }


        tree.root.print();

        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < 1000; i++) {
            int key = rnd.nextInt(1000);
            long t0 = System.nanoTime();
           tree.lookup(key);
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }
        double t=(min/1000);
        double t2=t/Math.log(n);
        double t3=t/n;

        System.out.printf("%8.5f\n" , t);
        System.out.printf("%8.5f\n" , t2);
        System.out.printf("%8.5f\n" , t3);
        //tree.root.inOrder();



       /* binaryTree Tree =new binaryTree();
        TreeIterator iterator = new TreeIterator(Tree);
        Tree.add(5,105);
        Tree.add(2,102);
        Tree.add(7,107);
        Tree.add(1,101);
        Tree.add(8,108);
        Tree.add(6,106);
        Tree.add(3,103);
        for (int i : Tree)
            System.out.println("next value " + i);*/
    }

}
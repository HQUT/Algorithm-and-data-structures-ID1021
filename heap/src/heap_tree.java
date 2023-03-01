import java.util.Random;

public class heap_tree {
        Node root;
      public heap_tree(){
        root= null;
    }

        public class Node {
            Integer priority;
            Integer size;
            Node left;
            Node right;

          public Node(Integer prio) {
                this.priority = prio;
                this.size = 0;
                this.left = null;
                this.right = null;
            }



            private Integer add(Integer prio) {
                if (prio < this.priority) {
                    Integer temp = this.priority;
                    this.priority = prio;
                    prio = temp;
                }
                this.size += 1;
                if (this.left == null) {
                    this.left = new Node(prio);
                    return 1;
                } else if (this.right == null) {
                    this.right = new Node(prio);
                    return 1;
                } else if (this.right.size < this.left.size) { // balanserra
                    return this.right.add(prio) + 1;
                } else {
                    return this.left.add(prio) + 1;
                }
            }

            private Node remove() {
                if (this.left == null && this.right == null) {
                    return null;
                } else if (this.left == null) {
                    return this.right;
                } else if (this.right == null) {
                    return this.left;
                } else if (this.left.priority < this.right.priority) {
                    this.priority = this.left.priority;
                    this.left = this.left.remove();

                } else {

                    this.priority = this.right.priority;
                    this.right = this.right.remove();
                }
                this.size = -1;
                return this;

            }
            private void print(Integer n){
                System.out.println(" " .repeat(n) + this.priority);
                if(this.left != null)
                    this.left.print(n+2);
                else
                    System.out.println(" ".repeat(n+2)+ "-----");
                if(this.right != null)
                    this.right.print(n+2);
                else
                    System.out.println(" ".repeat(n+2)+ "-----");
            }


        }

      public void print() {
            if (root != null) {
                root.print(2);
            } else
                System.out.println(" empty");

        }

        public Integer enqueue(Integer prio) {
            if (root != null)
                return root.add(prio); // lägga ett nude
            else
                root = new Node(prio);
            return 0;
        }

        public Integer dequeue() {
            if (root != null) {
                Integer ret = root.priority;
                root.remove();
                return ret;
            } else
                return null;
        }

        public static void main(String[] arg) {
            heap_tree queue = new heap_tree();
            Random rnd=new Random();
            for (int i=0; i<73; i++){
                queue.enqueue(rnd.nextInt(100));
            }
            queue.print();

            Integer d =0;
            for(int i=0; i<20;i++){
                d= queue.enqueue(rnd.nextInt(10));
                System.out.println("depth " + d);
            }

        }

    }



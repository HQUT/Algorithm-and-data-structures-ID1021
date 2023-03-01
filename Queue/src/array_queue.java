public class array_queue  {
    Integer size = 3;
    Object[] arr;
    Integer front ;
    Integer last;

 array_queue(){
        this.size = size;
        this.front = -1;
        this.last = -1;
        arr = new Object[size];

    }
    public boolean isEmpty(){
        return ( front == -1 || front > last);

    }

    public boolean isFull() {
        return (last == size-1) ;
    }
    public void enqueue ( Integer value) {
        if (isFull()) {
            System.out.println("No space");
        return;

        }
        last+=1;
        arr[last] = value;
        if(front  == -1){
            front = 0;
        }

        System.out.printf("Inserting %d\n", value);

    }
    public Object dequeue () {
        if (isEmpty()) {
            System.out.println("\n the quene is empty, nothing to delete :(:(");
            System.exit(-1);
        }
         Object delete = arr[front];
            front++;
        System.out.printf("removing %d\n", delete);
         return delete;

    }

    public static void main (String [] args){
       array_queue a_queue = new array_queue();
        a_queue.enqueue(10);
        a_queue.enqueue(11);
        a_queue.enqueue(5);
        a_queue.enqueue(3);
        a_queue.dequeue();
       a_queue.dequeue();
       a_queue.dequeue();


    }

}

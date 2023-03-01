public class dynamic_queue {
    Integer size = 3;
    Object[] arr;
    Integer front ;
    Integer last;

    dynamic_queue(){
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
    public void expand (){
        Object[] newarr= new Object[size*2];
        for ( int i=0; i< size; i++){
            if(isFull()){
                newarr[i]= arr[i];
            }

        }
        arr=newarr;
        size=2*size;
    }
    public void kont(){
        Object[] smallarr = new Object[size/2];
        for(int i=0; i<size; i++){
            if(isEmpty()){
                smallarr[i]=arr[i];
            }
            arr = smallarr;
            size = size/2;
        }
    }

    public void enqueue ( Integer value) {
        if (isFull())
            expand();

        last+=1;
        arr[last] = value;
        if(front  == -1){
            front = 0;
        }

        System.out.printf("Inserting %d\n", value);

    }
    public Object dequeue () {
        if (isEmpty()) {
            System.out.println("\n the quene is empty, nothin to delete :(, :(");

            System.exit(-1);
        }
        Object delete = arr[front];
        front++;
        System.out.printf("removing %d\n", delete);
        return delete;

    }

    public static void main (String [] args){
        dynamic_queue d_queue = new dynamic_queue();
        d_queue.enqueue(10);
        d_queue.enqueue(11);
        d_queue.enqueue(5);
        d_queue.enqueue(3);
        d_queue.enqueue(4);
        d_queue.enqueue(6);
        d_queue.enqueue(7);
        d_queue.enqueue(8);
        d_queue.dequeue();
        d_queue.dequeue();
        d_queue.dequeue();
        d_queue.enqueue(1);
        d_queue.dequeue();


    }
}

import java.util.Random;
public class Circular_queue <T>{
    Integer size = 3;
    private  T[] arr;
    Integer front ;
    Integer last;

     Circular_queue(){
         this.size = size;
         this.front = -1;
         this.last = -1;
         arr = (T[]) (new Object[size]);

    }
    public boolean isEmpty(){
         if( front == -1 && last ==-1)
             return true;
          else return false;
    }

    public boolean isFull() {
        if ((last + 1) % size == front) return true;
        else return false;
    }
    public void expand (){
        Object[] newarr= new Object[size*2];
        for ( int i=0; i< size; i++){
            if(isFull()){
                newarr[i]= arr[i];
            }

        }
        arr= (T[]) newarr;
        size=2*size;
    }
    public void enqueue (T value) {
        if (isFull()) {
           expand();
        }
         if( front == -1)
             front = 0;
            last = (last + 1) % size;
            arr[last] =  value;

            System.out.printf("Inserting %d\n", value);

    }
   public  Object dequeue () {

       if (isEmpty()){
           System.out.println("\n the quene is empty, nothing to delete :(, :(");
       System.exit(-1);}

             Object value = arr[front];
               if (front == last) {
                   front = last = -1;

               }
               else
                   front = (front + 1) % size;

            return (value);
       }



    void display() {
        if (isEmpty()) {
        } else {
            System.out.println("Front" + front);

            System.out.println("Rear " + last);
        }
    }

    public static void main (String [] args){
         Circular_queue<Integer> c_queue = new Circular_queue<>();
         Random rnd= new Random();
         int k=20;
         for(int i=0; i<k ;i++){
             c_queue.enqueue(rnd.nextInt(100));
         }
        c_queue.display();





    }



}

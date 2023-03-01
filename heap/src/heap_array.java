import java.util.Arrays;
import java.util.Random;

public class heap_array {
    public  int [] arr;
    public int size;
    public int index;
    public heap_array(int size){
       this.size = size;
        index = 0;
        arr = new int[size];
    }
    public int Parent (int i){
        return (i-1)/2;
    }
    public int Leftchild(int i) {
        return (i * 2) +2;
    }
    public int Rightchild(int i){
        return (i*2) +1;
    }
    public boolean leaf(int i){
        if(Rightchild(i)>= size || Leftchild(i)>= size){
            return true;
        }
        return false;
    }
    public void insert (int element){
        if(index >= size){
            return;
        }
        arr[index] = element;
        int current  = index;
        while(arr[current] <arr[Parent(current)]) {
            swap(current, Parent(current));
            current = Parent(current);
        }
        index++;
    }
    public int remove(){
        int removed = arr[0];
        arr[0] = arr[--index];
        heapify(0);
        return removed;
    }


    public void swap( int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void heapify ( int ParentIndex) {
        if (!leaf(ParentIndex))
            if (arr[ParentIndex] > arr[Leftchild(ParentIndex)] || arr[ParentIndex] > arr[Rightchild(ParentIndex)]) {
                if (arr[Leftchild(ParentIndex)] < arr[Rightchild(ParentIndex)]) {
                    swap(ParentIndex, Leftchild(ParentIndex));
                    heapify(Leftchild(ParentIndex));
                } else {
                    swap(ParentIndex, Rightchild(ParentIndex));
                    heapify(Rightchild(ParentIndex));
                }
            }
    }
    public void build_heap(){
        for( int i= (index -1/2); i>=1;i--){
            heapify(i);
        }
    }

    public void printHeap() {
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent : " + arr[i]);
            if (Leftchild(i) < index)
                System.out.print(" Left : " + arr[Leftchild(i)]);
            if (Rightchild(i) < index)
                System.out.print(" Right :" + arr[Rightchild(i)]);
            System.out.println();
        }
    }



    public static void main(String [] args){
        int k=2560;
        double ti=0;
        double tr=0;
       heap_array heap = new heap_array(k);
        Random rnd = new Random();
      
            for (int i = 0; i < (k*100); i++) {
              
                heap.insert(rnd.nextInt(1000));
               
            }

   
        heap.build_heap();
        System.out.println("The Heap is : " + Arrays.toString(heap.arr));
        heap.printHeap();
       // System.out.println("\n the time it takes to add: "+ ti/(1000 ));
        //System.out.println("\n is it log: "+ (ti/(1000 ))/Math.log(k));
        double min2=Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
               // System.out.println("\nThe Min Value is : ");
                long t = System.nanoTime();
                heap.remove();
                long t1 = System.nanoTime();
                double t5 = (t1 - t);
                tr += t5;
            }

        //System.out.println("\nThe Min Value is : " + heap.remove());
        //System.out.println("\nThe Min Heap is :"+ Arrays.toString(heap.arr));
        heap.build_heap();
        //heap.printHeap();
        System.out.println("\n the time it takes to remove : "+ tr/(k ));

    }
}

import java.util.Random;
import java.util.Arrays;
public class main {
    public static void main(String[] args){
        Random rnd= new Random();
        int k =10240;
        int[] sequence=new int[50000];
        int [] arr= new int[k];
        int low = 0;
        int high = arr.length-1;
        Linked_list list = new Linked_list();
       // System.out.println("the sequence with random number; ");
        for(int i= 0; i< sequence.length; i++){
            sequence[i] = rnd.nextInt(50000);
        }
       // System.out.println(Arrays.toString(sequence));

       // System.out.println("\n the array before sorting; ");
        for(int i=0; i< arr.length;i++){
            arr[i]= sequence[i];
        }
       // Quicksort.printArray(arr,arr.length);
        //System.out.println(Arrays.toString(arr));

       // System.out.println("\n the arrat efter sorting:");
        double min1 = Double.POSITIVE_INFINITY;
        for(int j=0 ; j<1000 ;j++) {
            long t2 = System.nanoTime();
        Quicksort.quickSort(arr,low,high);
            long t3 = System.nanoTime();
            double t1 = (t3 - t2);
            if (t1 < min1)
                min1 = t1;
        }
        double t_arr = (min1/1000);
        double t= t_arr/(k*(Math.log(k)));
       // Quicksort.printArray(arr,arr.length);
        System.out.println("\n Time it takes to sort the arrar: "+ t_arr);
        System.out.println("\n log or not? "+ t);

       // System.out.println("\n the list before sorting: ");
        for(int i =0; i< k;i++){
            int value =sequence[i];
            list.add(value);
        }
       // list.printList(list.head);

        Linked_list.Node n = list.head;
        while (n.next != null)
            n = n.next;
        double min2= Double.POSITIVE_INFINITY;
        for(int i= 0; i<1000; i++) {
            long t4 = System.nanoTime();
            list.sort(list.head, n);
            long t5 = System.nanoTime();
            double t6 = (t5 - t4);
            if (t6 < min2)
                min2 = t6;
        }
        double t_list = (min2/1000);
        double log= t_list/(k*(Math.log(k)));
       // System.out.println("\nThe list efter sorting: ");
       // list.printList(list.head);
        System.out.println("\n the time it takes to sort a list: "+t_list);
        System.out.println("\n is it log komplexity? " +log);
        System.out.println("\n k? " + t_list/t_arr);
    }
}

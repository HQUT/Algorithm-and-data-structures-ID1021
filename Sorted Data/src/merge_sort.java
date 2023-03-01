import java.util.*;
public class merge_sort {

    public static void sort(int[] org) {
        if (org.length == 0)
            return;
        int[] aux = new int[org.length];
        sort( org, aux, 0, org.length - 1);
    }

    private static void sort(int org[],int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = lo + (hi - lo) / 2;
// sort the items from lo to mi
           sort(org,aux,lo, mid);

// sort the items from mid+1 to hi
           sort(org,aux,mid+1,hi);

// merge the two sections using the additional array
          merge(org, aux, lo, mid, hi);

        }
    }

    private static void merge( int[]org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for ( int i=lo; i<=hi; i++ ){
            aux[i]=org[i];
        }
// let's do the merging
        int i = lo; // the index in the first part
        int j = mid + 1; // the index in the second part
        // for all indeces from lo to hi
        for (int k = lo; k <=hi; k++) {
// if i is greater than mid, move the j item to the org array, update j
         if(i>mid){
             org[k]=aux[j];
             j++;
         }
// else if j is greate than hi, move the i item to the org array, update i
            if(j>hi){
                org[k]=aux[i];
                i++;
            }
// else if the i item is smaller than the j item ,move it to the org array, update i

            if (aux[i]< aux[j]){
                org[k]=aux[i];
                i++;
            }

// else you can move the j item to the org array, update j
            else{
                org[k]=aux[j];
               j++;
            }

        }
    }


    public static void main(String[] args) {
        long t_access = 0;
        long t=0;
        int[] array = new int[10];
        int [] aux= new int[10];
        int hi= aux.length-1;
        int mid=aux.length/2;
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1000);
        }
        System.out.println(java.util.Arrays.toString(array));
        for (int j = 0; j <= 1000; j++) {
            long t0 = System.nanoTime();

            //merge(array,aux,0,mid,hi);
            sort(array);
            long t1=System.nanoTime();
            t_access+=(t1-t0);

        }
        t= t_access/1000;
        System.out.println(java.util.Arrays.toString(aux));
        System.out.println(t);

    }
}
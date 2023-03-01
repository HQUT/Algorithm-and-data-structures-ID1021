import java.util.*;
public class no_efficient {

    public static void selection_sort(int[] array) {

        //int length=array.length;
        for (int i = 1; i < array.length - 1; i++) {

            int cand = i;
        

            for (int j = 0 ; j < array.length; j++) {
                // If the element at position j is smaller than the value
                // at the candidate position - then you have a new candidate
                // posistion.

                if (array[j] < array[cand])
                    cand = j;
            }

            int newcand = array[cand];
            // Swap the item at position i with the item at the candidate position.
            array[cand] = array[i];

            array[i] = newcand;


        }


    }

    public static void more_effeicent(int[] array2) {

        for (int i = 0; i < array2.length-1; i++) {
            if (array2[i] > array2[i+1]) {
                int key = array2[i+1];
                array2[i + 1] = array2[i];

                array2[i] = key;
            }


           for (int j = i; j > 0 && array2[i + 1] < array2[i]; j--) {

                array2[j] = array2[j+1];
            }
        }
    }
    public static void insection_sort(int[]array) {

        for (int i = 1; i < array.length; i++) {
            int j=i-1;
            int key = array[i];
// for each element from i towards 1, swap the item found with the
// item before it if it is smaller
            while(j > 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;

            }
                array[j + 1] = key;
            }


        }





    public static void main(String[] args) {
        int[] array = new int[100];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1000);
        }
        System.out.println(java.util.Arrays.toString(array));
        double min = Double.POSITIVE_INFINITY;
        for (int j = 0; j <100; j++) {
            long t0 = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                insection_sort(array);
                long t1 = System.nanoTime();
                double t_access = (t1 - t0);
                if (t_access < min)
                    min = t_access;
            }
        }
        double t= min/1000;
        System.out.println(java.util.Arrays.toString(array));
        System.out.println(t);

    }
}

import java.util.Random;
import java.lang.Math;

public class newmwege {
   public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {

        double t=0;
        int[] array = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1000);
        }
        System.out.println(java.util.Arrays.toString(array));
        double min = Double.POSITIVE_INFINITY;
        for (int j = 0; j < 100; j++) {
            long t0 = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                sort(array, 0, array.length - 1);
                long t1 = System.nanoTime();
                double t_access = (t1 - t0);

                if (t_access < min)
                    min = t_access;
            }

        }
        t= min/(1000);
        double t1= t/(array.length*Math.log(t));
        double t2=t/(array.length);
        System.out.println(java.util.Arrays.toString(array));
        System.out.printf("#%7s%8s%8s\n", " tid" ," t/n", "  logaritm");
        System.out.printf("%8.5f ",t);
        System.out.printf("%8.5f ",t2);
        System.out.printf("%8.5f ",t1);


    }
}

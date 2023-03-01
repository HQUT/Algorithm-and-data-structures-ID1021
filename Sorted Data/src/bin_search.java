import java.awt.*;
import java.util.Random;

public class bin_search {
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (true) {
            // jump to the middle
            int index = first + ((last-first)/2);
            if (array[index] == key) {
                //System.out.println("found");
                return true;
            }
            if (array[index] < key && index < last) {
// The index position holds something that is less than
// what we're looking for, what is the first possible page?
                first = index +1 ;

                continue;
            }
            if (array[index] > key && index > first) {
// The index position holds something that is larger than
// what we're looking for, what is the last possible page?
                last = index-1;
                continue;
            }
            break;
        }
        // Why do we land here? What shoudl we do?System.out.println("not found");
            return false;



    }

    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] index = new int[loop];
        int next = 0;
        for (int i = 0; i < loop; i++) {
            next += rnd.nextInt(n*10) + 1;
            index[i] = next;
        }
        return index;
    }



    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    private static void binary(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            binary_search(array, indx[i]);
        }
    }
    public static void main(String[] arg) {

        int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s\n ", " n ", " binary ");
        for ( int n : sizes) {

            int loop = 10000;

            int[] array = sorted(n);
            int[] indx = keys(loop, n);

            System.out.printf("%8d ", n);

            int k = 1000;

            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                binary(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.5f\n  " , (min/loop));
        }
    }


}

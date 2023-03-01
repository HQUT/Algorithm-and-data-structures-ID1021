import java.util.Arrays;
import java.util.Random;
public class AppendArray {
    public void appendArrays(int[] arr1, int[] arr2) {
        int length = arr1.length + arr2.length;
        int[] result = new int[length];
        int pos = 0;
        for (int element : arr1) {
            result[pos] = element;
            pos++;
        }
        for (int element : arr2) {
            result[pos] = element;
            pos++;

        }System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        AppendArray aa = new AppendArray();
        Random rnd = new Random();
        double t=0;
        int size = 51200;
        //int size2 = 10;
        long t0 = System.nanoTime();
        int[] n1 = new int[size];

            for (int i = 0; i <= n1.length - 1; i++) {
                n1[i] = rnd.nextInt(100);
            }



                long t1 = System.nanoTime()-t0;




        t= t1/1000;
        System.out.printf("%8.5f ",t);

    }

}

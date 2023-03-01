import java.util.Random;
public class sorterad {
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

    public static boolean sorted1(int[] array, int n) {

        Random ran = new Random();
        int key = ran.nextInt(10);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= key) {
                if (array[i] == key) {
                    System.out.println("found");
                    return true;
                }
                else {
                    return false;
                }
            }
        } return false;


    }


    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] index = new int[loop];
        for (int i = 0; i < index.length; i++) {
            index[i] = rnd.nextInt(n * 5);
        }
        return index;
    }

    private static void binary(int[] array, int[] indx) {
        for (int i = 0; i < indx.length; i++) {
            sorted1(array, indx[i]);
        }
    }


    public static void main(String[] args) {

        int[] sorted_array = sorted(10);
        Random ran = new Random();
        int key = ran.nextInt(10);
        long t0 = 0;
        long t_access =0;
        long t=0;
      for (int i = 0; i < sorted_array.length; i++) {
            t0 = System.nanoTime();
            if (key<= sorted_array[i] ) {
                        System.out.println("Found this number: " + sorted_array[i]);
                        break;}

            if(key < sorted_array[i++]){
                        System.out.println ("not found");
                        break;}

            }
        t_access += (System.nanoTime() - t0);
      t= t_access/ sorted_array.length;

        for (int n : sorted_array) System.out.printf("%3d ", n);
        System.out.println();
       System.out.println(key + "\n");
        System.out.println("tiden är: " + (double) t_access + " nonsekubds");


    }
}




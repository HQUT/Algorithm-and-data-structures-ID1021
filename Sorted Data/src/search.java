import java.util.Random;
public class search{
    public static boolean search_unsorted(int [] array,int key){
        for (int index=0; index< array.length; index++){
            if (array[index]==key){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] s = new int[80];
        Random ran = new Random();
        int key = ran.nextInt(100);
        long t0 = System.nanoTime();
        for (int i = 0; i < s.length; i++) {
            s[i] = ran.nextInt(100);
        }
        long t_access = (System.nanoTime() - t0);
        boolean r = search_unsorted(s, key);
        for(int n:s)System.out.printf("%3d ", n);
        System.out.println("\n"+key );
        System.out.println("efter sökning svar är; " + r);
        System.out.println("Tiden det tog för följande sökning är: " + (double) t_access + "nanosekunds");
    }

}

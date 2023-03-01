import java.util.Random;

public class duplicates {
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (true) {
            // jump to the middle
            int index = first + ((last-first)/2);
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {

                first = index +1 ;

                continue;
            }
            if (array[index] > key && index > first) {

                last = index-1;
                continue;
            }
            break;
        }
     

        return false;



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

    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] index = new int[loop];
        int next=0;
        for (int i = 0; i < loop; i++) {
            next += rnd.nextInt(n * 2)+1;
            index[i]= next;
        }
        return index;
    }

    public static void main(String[] args){
        int [] key = keys(2400000,100);
        int [] bin= sorted(2400000);
        long t0= 0;
        long t1=0;
     for (int i =0; i<key.length; i++){
         t0= System.nanoTime();
         int ke= key[i];

             //binary_search(bin, ke);
             if(binary_search(bin, ke)== true){
                 System.out.println("found " +ke );
             }
             if(binary_search(bin,ke)==false){
                 System.out.println("not found :'( :'( ");
             }
         t1= System.nanoTime();

     }
        double t= (t1-t0);

        System.out.println(key[0]);
        System.out.println(key[1]);
        System.out.println(key[2]);
        System.out.println(key[3]);
        System.out.println(key[4] + "\n");

        System.out.println(bin[0]);
        System.out.println(bin[1]);
        System.out.println(bin[2]);
        System.out.println(bin[3]);
        System.out.println(bin[4]);
        //System.out.println(binary_array);
        System.out.println(t);
    }

}

import java.util.Random;

public class newversion {
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(5) + 1;
            array[i] = nxt;
        }
        return array;
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

    public static boolean newver(int[] key, int[] sor) {

        int i = 0;
        int j = 0;
        int last = key.length;
        int last1 = sor.length;

        while (true) {
            if (i == last || j == last1) {
                break;
            }
                if (key[i] == sor[j] && i <= last && j <= last1) {
                    System.out.println("hittad följände " + sor[j]);
                   i++;
                   j++;
                   continue;
                }

            if (key[i] < sor[j] && i <= last) {
                i = i + 1;
                continue;
            }
            if (key[i] > sor[j] && j <= last1) {
                j = j + 1;
                continue;
            }break;

        }


        return false;
        }





        public static void main(String[] args){
         int[] key = keys(6400, 50);
        int[] sor = sorted(6400);
        long t0 = System.nanoTime();
           newver(key, sor);
        long t1= System.nanoTime();
        double t= (t1-t0);
        for(int n:key)System.out.printf("%3d ", n );
        System.out.println();
        for(int n1:sor)System.out.printf("%3d ", n1);
            System.out.println();
        System.out.println(t);
        }
}





import java.util.Arrays;
import java.util.Random;

public class bin_sök {
        public static void commonElement(int[] array1, int[] array2) {
            int index1 = 0;       
            int index2 = 0;

            while (index2 < array2.length && index1 < array1.length) {
                int left1 = 0, right1 = (array1.length)-1;     
                while (left1 <= right1) {
                    int mid1 = (left1 + right1)/2;
                    if (array2[index2] == array1[mid1]) {
                        System.out.print( " common element is " + array1[mid1] );
                        break;
                    } else if (array2[index2] > array1[mid1])
                        left1 = mid1 + 1;                 
                    else right1 = mid1 - 1;
                }

                index2++;  
            }
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

    public static void main(String[] args) {
        long t_acces=0;
            int[] exarray1 = sorted(1500);
            int[] exarray2 = sorted(1500);
            long t0=System.nanoTime();
            commonElement(exarray1,exarray2);

        t_acces +=(System.nanoTime()-t0);
        System.out.println();
            System.out.println(t_acces);

            System.out.println("END");
        }
    }


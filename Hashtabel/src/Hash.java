import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class Hash {
    Node[] data;
    int mod;
    int[] keys;
    int max;

    private class Node {
        private Integer code;
        private String name;
        private Integer population;

        public Node(Integer code, String name, Integer population) {
            this.code = code;
            this.name = name;
            this.population = population;
        }
    }

    public Hash(String file, int mod) {
        this.mod = mod; // save the modulo so that it can be used between methods
        data = new Node[mod]; // make the data array that will hold the nodes the size of modulo that will be
        // used to hash the keys.
        this.keys = new int[9675];// the csv file is 9,675 lines
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            int code = 0;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                code = Integer.parseInt(row[0].replaceAll("\\s", ""));
                this.keys[i++] = code;
                insert(code, new Node(code, row[1], Integer.valueOf(row[2])));
                // row[0] is code, row[1] is name and row[2] is population
            }
            max = i - 1; // max is number of zip nodes
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    private void insert(Integer code, Node entry) {
        Integer key = code % this.mod; // get the hash index
        while (this.data[key] != null) {// if the index is already occupied step forward to next empty spot
            key++;
        }
        this.data[key] = entry; // save the entry at the empty spot
    }

    public String lookup(Integer code) {
        Integer key = code % this.mod;
        while (!this.data[key].code.equals(code)) {
            key++;
        }
        return this.data[key].name;
    }

    public void countStepsInLookup() {
        int steps = 0;
        int max = 0;
        double average = 0;
        double numberOfTimesWeNeedToStep = 0;
        for (int i = 0; i < this.keys.length; i++) {
            int code = this.keys[i];
            Integer key = code % this.mod;
            steps = 0;
            while (!this.data[key].code.equals(code)) {
                key++;
                steps++;
                average++;
            }
            if (steps > 0) {
                System.out.println("for code " + code + ", steps = " + steps);
                numberOfTimesWeNeedToStep++;
            }
            if (steps > max) {
                max = steps;
            }
        }
        System.out.println("max steps was: " + max);
        System.out.println("average steps was " + average / numberOfTimesWeNeedToStep);
        System.out.println("average number of times we needed to step was " + average / this.keys.length);
    }
    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod+"\n");
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

    public int nrOfCollisions() {
        Set<Integer> store = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < keys.length; i++) {

            if (store.add(keys[i] % this.mod) == false) {
                count++;
                System.out.println("Duplicate element found : " + keys[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int mod = 31333;
        Hash hash = new Hash("/Users/hibaqutbuddinhabib/IdeaProjects/hashTabel/src/postnummer.csv", mod);
        hash.countStepsInLookup();

        //System.out.println("number of collisions for mod=" + mod + " is " +
        //hash.nrOfCollisions());

       // hash.collisions(mod);

        int k = 11000;
        // warm up so that we hopefully get better benchmark results
        for (int i = 0; i < k; i++) {
            hash.lookup(11115);
        }

        long timeStart = System.nanoTime();
        for (int i = 0; i < k; i++) {
            hash.lookup(11115);
        }
        long timeStop = System.nanoTime();
        System.out.println("Lookup 111 15: " + hash.lookup(11115) + (timeStop - timeStart) / k + "ns");

        // warm up so that we hopefully get better benchmark results
        for (int i = 0; i < k; i++) {
            hash.lookup(98499);
        }
        timeStart = System.nanoTime();
        for (int i = 0; i < k; i++) {
            hash.lookup(98499);
        }
        timeStop = System.nanoTime();
        System.out.println("Lookup 984 99: " + hash.lookup(98499) + (timeStop - timeStart) / k + "ns");
    }
}

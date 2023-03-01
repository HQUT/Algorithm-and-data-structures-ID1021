import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T9 {
    Node root;

    public class Node {
        public Node[] next;
        public boolean word;
        public char character;

        public Node() {
            next = new Node[27];
            word = false;
        }
        public Node(char c){
            next = new Node[27];
            word = false;
            character = c;
        }

        public Node get(int index)
        {
            if (index < 0 || index > 29) return null;
            return next[index];
        }


    }
    public T9() {
        root = new Node();
    }

    public int giv_character_get_code(char character) {
        int code = -1;
        switch (character) {
            case 'a':
                code = 0;
                break;
            case 'b':
                code = 1;
                break;
            case 'c':
                code = 2;
                break;
            case 'd':
                code = 3;
                break;
            case 'e':
                code = 4;
                break;
            case 'f':
                code = 5;
                break;
            case 'g':
                code = 6;
                break;
            case 'h':
                code = 7;
                break;
            case 'i':
                code = 8;
                break;
            case 'j':
                code = 9;
                break;
            case 'k':
                code = 10;
                break;
            case 'l':
                code = 11;
                break;
            case 'm':
                code = 12;
                break;
            case 'n':
                code = 13;
                break;
            case 'o':
                code = 14;
                break;
            case 'p':
                code = 15;
                break;
            case 'r':
                code = 16;
                break;
            case 's':
                code = 17;
                break;
            case 't':
                code = 18;
                break;
            case 'u':
                code = 19;
                break;
            case 'v':
                code = 20;
                break;
            case 'x':
                code = 21;
                break;
            case 'y':
                code = 22;
                break;
            case 'z':
                code = 23;
            break;
            case 'å':
                code = 24;
            break;
            case 'ä':
                code = 25;
            break;
            case 'ö':
                code = 26;
            break;
        }
        return code;
    }

    public char give_code_get_character(int code) {
        char character = '_';
        switch (code) {
            case 0:
                character = 'a';
                break;
            case 1:
                character = 'b';
                break;
            case 2:
                character = 'c';
                break;
            case 3:
                character = 'd';
                break;
            case 4:
                character = 'e';
                break;
            case 5:
                character = 'f';
                break;
            case 6:
                character = 'g';
                break;
            case 7:
                character = 'h';
                break;
            case 8:
                character = 'i';
                break;
            case 9:
                character = 'j';
                break;
            case 10:
                character = 'k';
                break;
            case 11:
                character = 'l';
                break;
            case 12:
                character = 'm';
                break;
            case 13:
                character = 'n';
                break;
            case 14:
                character = 'o';
                break;
            case 15:
                character = 'p';
                break;
            case 16:
                character = 'r';
                break;
            case 17:
                character = 's';
                break;
            case 18:
                character = 't';
                break;
            case 19:
                character = 'u';
                break;
            case 20:
                character = 'v';
                break;
            case 21:
                character = 'x';
                break;
            case 22:
                character = 'y';
                break;
            case 23:
                character = 'z';
                break;
            case 24:
                character = 'å';
                break;
            case 25:
                character = 'ä';
                break;
            case 26:
                character = 'ö';
                break;
        }
        System.out.println(character);
        return character ;
    }
    public int giv_key_get_index(char key){
        int index = -1;
        switch (key){
            case '1':
                index = 0;
                break;
            case '2':
                index = 3;
                break;
            case '3':
                index = 6;
                break;
            case '4':
                index = 9;
                break;
            case '5':
                index = 12;
                break;
            case '6':
                index = 15;
                break;
            case '7':
                index = 18;
                break;
            case '8':
                index = 21;
                break;
            case '9':
                index = 24;
                break;

        }
        System.out.println(index);
        return index;
    }

    public String giv_character_get_key(char character){
        int code= giv_character_get_code(character);
        String key ;
        if (code <3) {
            key = "1";
        }else if (code <6){
            key ="2";
        }else if(code <9){
            key ="3";
        }else if(code <12){
            key = "4";
        }else if(code <15){
            key = "5";
        }else if(code <18){
            key = "8";
        }else if(code <21){
            key = "7";
        }else if(code <24){
            key = "8";
        }else {
            key = "9";
        }
        System.out.print(key);
        return key;
    }

    public void add(String word) {
        if(word == null || word.isEmpty()){
            throw  new IllegalArgumentException("please write a word :) :)");
        }
        Node nod = root;
        for (int i = 0; i < word.length(); i++) {
            char cha = word.charAt(i);
            int index = giv_character_get_code(cha);
            System.out.println(index);
            if (nod.next[index] == null) {
                Node newnode = new Node();
                nod.next[index] = newnode;
                nod = newnode;
            } else {
                nod = nod.next[index];
            }
        }

        nod.word = true;
    }

    private void recursiveSearch(char[][] outcomes, int index, Node node, String word)
    {
        int length = outcomes[0].length;
        if (index < length)
        {
            for (int i = 0; i < 3; i++)
            {
                char c = outcomes[index][i];
                var node2 = node.get(c);
                if (node2 != null)
                {
                    String temp = word + node2.character;
                    recursiveSearch(outcomes, index + 1, node2, temp);
                    System.out.println(temp);
                }
            }
        }
        else
        {
            if(node.word) System.out.println(word);
            for (int i = 0; i < 30; i++)
            {
                var node2 = node.get(i);
                if (node2 != null)
                {
                    String temp = word + node2.character;
                    recursiveSearch(outcomes, index + 1, node2, temp);
                }
            }
        }
    }

    public void searchWord(String sequence){
        char [][] outcomes = new char[sequence.length()][3];
        for (int i = 0; i < sequence.length(); i++)
        {
            char[] cc = numberToChar(sequence.charAt(i));
            System.arraycopy(cc, 0, outcomes[i], 0, cc.length);
            System.out.println(cc);
        }
        recursiveSearch(outcomes, 0, root, "");
    }

    private char[] numberToChar(char c)
    {
        int number = c - '0';
        if(number==1) return new char[] { 'a', 'b', 'c' };
        if(number==2) return new char[] { 'd', 'e', 'f' };
        if(number==3) return new char[] { 'g', 'h', 'i' };
        if(number==4) return new char[] { 'j', 'k', 'l' };
        if(number==5) return new char[] { 'm', 'n', 'o' };
        if(number==6) return new char[] { 'p', 'q', 'r' };
        if(number==7) return new char[] { 's', 't', 'u' };
        if(number==8) return new char[] { 'v', 'w' ,'x'};
        if(number==9) return new char[] { 'y','z', 'å' };
        if(number==0) return new char[] { 'ä','ö', ' ' };
        throw new NoSuchElementException();
    }

    public Node generateDictionary(){
        Node root = new Node();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/hibaqutbuddinhabib/IdeaProjects/T9/src/kelly.txt"))){
            String line = "";
            while((line = br.readLine()) != null){
                Node current = root;
                System.out.println(line);
                for(char c : line.toCharArray()){
                    int i = charTranslator(c);
                    if(current.next[i] == null)
                        current.next[i] = new Node();
                    current = current.next[i];
                }
                current.word = true;
                System.out.println();
            }
        }
        catch (IOException fe) {
            System.out.println("File not found");
        }
        return root;
    }


    public static int charTranslator(char c){
        int character = (int)c;
        if(character == 113) character++;
        if(character == 119) character++;
        System.out.println((char)character);
        character -= 97;
        if(character == 131) character = 24;
        if(character == 132) character = 25;
        if(character == 149) character = 26;
        return character;
    }


    static boolean searchRecursively(Node itr, char[] str, int i, int len)
    {
        if (itr == null)
            return false;
        if (itr.word == true && i == len - 1)
        {
            return true;
        }

        int index = str[i] - 'a';
        return searchRecursively(itr.next[index], str, i + 1, len);
    }
    static void search(Node root, String str)
    {
        char[] arr = new char[str.length() + 1];
        for(int i = 0; i < str.length(); i++)
        {
            arr[i] = str.charAt(i);
        }
        if (searchRecursively(root, arr, 0, str.length() + 1))
            System.out.println("found");

        else {
            System.out.println("not found");
        }
    }





    public static void main(String[] arg){
       T9 trie = new T9();
      trie.add("hello");
      String c= "toffel";
        for(int i= 0; i< c.length(); i++){
          char c1=c.charAt(i);
            trie.giv_character_get_key(c1);
      }

        trie.generateDictionary();
        System.out.println(trie.giv_character_get_code('l'));
        System.out.println(trie.give_code_get_character(2));

        search(trie.root, "hello");

    }
}

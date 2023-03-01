public class nod {
    int data;
    public nod previous;
    public nod next;

    public nod(int data) {
        previous = null;
        this.data = data;
        next = null;

    }
    public nod(nod previous, int data, nod next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public int getData(int data) {
        return data;
    }

}



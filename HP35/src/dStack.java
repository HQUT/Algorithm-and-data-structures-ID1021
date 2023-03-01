public class dStack {
    int top;
    int maxsize;
    int[] stack;

    dStack() {
        top = -1;
        maxsize = 4;
        stack = new int[maxsize];
    }

    public void expand() {
        int newStack[] = new int[maxsize * 2];
        for (int i = 0; i < maxsize; i++) {
            if (isFull()) {
            newStack[i] = stack[i];
            }
        }
            stack = newStack;
            maxsize = 2*maxsize;
        }


        public void kont () {
            int newstack1[] = new int[maxsize / 2];
            for (int i = 0; i < maxsize; i++) {
                if (isEmpty()) {
                    newstack1[i] = stack[i];
                }
                stack = newstack1;
                maxsize = maxsize / 2;
            }
        }
        public boolean isEmpty () {
            return top == -1;
        }
        public boolean isFull () {
            return top == maxsize - 1;
        }
        public int push ( int n){
            if (isFull()) {
                expand();
            }

            return stack[++top] = n;
        }

        public int pop () {
            if (isEmpty()) {
                kont();
            }
            return stack[top--];
        }
        public int peek () {
            return stack[top];
        }

    }


import java.util.Arrays;
public class Stack<Arr> {
private  Arr[] stack;
private int top;

public Stack() {
        this.stack =(Arr[]) new Object[1];
        this.top = 0;
        }

public void push(binaryTree.Node x)
        {
        if(this.top == size())
            resize(2*size());
        this.stack[this.top++] = (Arr) x;
        }

// Utility function to pop a top element from the stack
public binaryTree.Node pop()
        {
        // check for stack underflow
        if (isEmpty())
        {
        System.out.println("Underflow\nProgram Terminated");
        System.exit(-1);
        }
        if (this.top > 0 && this.top == size()/4)
        resize(size()/2);
        Arr remove = this.stack[top--];
        return (binaryTree.Node) remove;
        }
public void resize(int y)
        {
        Arr[] newStack = (Arr[]) new Object[y];
        for (int i = 0; i < this.top; i++) {
        newStack[i] = this.stack[i];
        }
        this.stack = newStack;
        }

public int size() {
        return top + 1;
        }

public boolean isEmpty() {
        return top == -1;
        }



}


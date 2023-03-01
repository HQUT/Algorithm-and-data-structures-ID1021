import java.lang.*;
import java.util.Stack;

public class stack {
    int top;
    int maxsize;
    int[] stack = new int[4];
    stack(){
       top =-1;
       maxsize=4;
       stack = new int[maxsize];
    }
    public boolean isEmpty(){
        return top ==-1;
    }
    public boolean isFull(){
        return top==maxsize-1;
    }
    public int push(int n){
        if (isFull()) {
           // System.out.println("Stack är full");
            throw new java.lang.ArrayIndexOutOfBoundsException("Stack is full");
        }
        return stack[++top]=n;

    }

    public int pop(){
        if(isEmpty()){
           // System.out.println("stack is Empty");
            throw new java.lang.NullPointerException("Satck is Empty");
        }
        return stack[top--];
    }
    public int peek(){
        return stack[top];
    }

    }


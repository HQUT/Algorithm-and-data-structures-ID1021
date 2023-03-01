
    class Stack {

        private class Node {

            int value; 
            Node next; 
        }

        Node top;

        public void Stack() {
            this.top = null;
        }
           
            public void push(int x) 
            {
              
                Node temp = new Node();

                
                if (temp == null) {
                    System.out.print("\nHeap Overflow");
                    return;
                }

                
                temp.value = x;

               
                temp.next = top;

               
                top = temp;
            }

           
            public boolean isEmpty() { return top == null; }

          
            public int peek()
            {
              
                if (!isEmpty()) {
                    return top.value;
                }
                else {
                    System.out.println("Stack is empty");
                    return -1;
                }
            }

           
            public void pop() 
            {
              
                if (top == null) {
                    System.out.print("\nStack Underflow");
                    return;
                }

                
                top = (top).next;
            }

            public void display()
            {
               
                if (top == null) {
                    System.out.printf("\nStack Underflow");
                }
                else {
                    Node temp = top;
                    while (temp != null) {

                        
                        System.out.printf("%d->", temp.value);

                    
                        temp = temp.next;
                    }
                }
            }
            public static void main(String[] args){
             Stack s=new Stack();
               s.push(100);
               s.push(30);
               s.push(50);

               s.display();
               System.out.printf("top",s.peek());
                s.pop();
                s.pop();

                s.display();
                System.out.printf("top",s.peek());

            }

        }



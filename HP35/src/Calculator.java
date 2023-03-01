public class Calculator {
    static Item[] expr;
    int ip;
    stack stack;


    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new stack();

    }

    public int run() {
        while (ip < expr.length) {
            step();
        }
        return  stack.pop();
    }

    public void step() {
        Item nxt = expr[ip++];
        switch (nxt.Type()) {
            case ADD: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case DIV: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                if (y == 0) {
                    System.out.println("Undefind, Varför delar du med 0");
                }
                if (y>x){
                    System.out.println("")
                }
                break;
            }
            case MUL: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
            }

            case modulos:{
                int y=stack.pop();
                if(y>10){
                    int n = y / 10;
                    int x=n*10;
                    stack.push(y-x);
                }
                if(y<10){
                    stack.push(0);
                }
                break;
            }
            case MULADD:{
                int y=stack.pop();
                int x= stack.pop();
                stack.push(x*y);
                int m=stack.pop();
                if (m>10){
                    stack.push(m %10);
                    stack.push(m=m/10);
                    int x1 =stack.pop();
                    int x2=stack.pop();
                    stack.push(x2+x1);

                }
                if (m<10){
                    stack.push(m);
                }
                break;

            }
            case VALUE:{
                stack.push(nxt.value());
            }




        }

    }


    }






public class main {
    public static void main(String[] args) {
        long t_total=0;
        long t=0;
        long t0=System.nanoTime();
            Item[] expr = {new Item(14, ItemType.VALUE),
                    new Item(7, ItemType.VALUE),
                    new Item (50, ItemType.VALUE),
                    new Item(3, ItemType.DIV)};

            dStack c = new dStack();

            //Item[]  expr={ new Item(3), new Item(5), add};


            Calculator calculator = new Calculator(expr);
            calculator.run();


                t_total =(System.nanoTime()-t0);
                System.out.println("resolutin " + t_total+ "nonoseconds");

                System.out.println(c.isFull());

        System.out.println("result: " + calculator.run());



    }
}

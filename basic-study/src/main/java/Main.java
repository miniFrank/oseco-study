public class Main {
    private int i = 0;
    private static int i1 = 1;
    private static final int i2 = 2;

    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public int add() {
        return this.i + i1;
    }

    public void sum() {
        int sum = this.i + i1;
        System.out.println("sum:" + sum);
    }

    public static int sub() {
        return i2 - i1;
    }

    public synchronized static void main(String[] args) {
        Main main = new Main();

        main.add();
        main.sum();
        main.compute();
        System.out.println("sub:" + Main.sub());

    }
}

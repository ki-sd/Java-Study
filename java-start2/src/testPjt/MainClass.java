package testPjt;

public class MainClass {
    public static void main(String[] args) {
        Grandeur myCar1 = new Grandeur();

        myCar1.run();
        myCar1.stop();
        myCar1.info();

        System.out.println();

        Grandeur myCar2 = new Grandeur();

        myCar2.run();
        myCar2.stop();
        myCar2.info();
    }
}

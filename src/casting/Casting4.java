package casting;

public class Casting4 {
    static void main(String[] args) {
        int div1 = 3 / 2; //int / int
        System.out.println("div1 = " + div1); //int / int이므로 int타입 결과

        double div2 = 3 / 2; //int / int
        System.out.println("div2 = " + div2); //int / int이므로 int타입 결과

        double div3 = 3.0 / 2; //double / int
        System.out.println("div3 = " + div3); // double / int이므로, double / double로 자동 형변환

        double div4 = (double) 3 / 2; //(double로 명시적 형변환) int / int -> double / double
        System.out.println("div4 = " + div4); //double / double -> double

        int a = 3;
        int b = 2;
        double result = (double) a / b;
        System.out.println("result = " + result);
    }
}

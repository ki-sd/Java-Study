package operator;

public class OperatorAdd2 {
    static void main(String[] args) {
        //전위 증감 연산자 사용 예
        int a = 1;
        int b = 0;
        b = ++a; //
        System.out.println("a = " + a + "b = " + b);

        //후위 증감 연산자 사용 예
        a = 1;
        b = 0;
        b = a++;
        System.out.println("a = " + a + "b = " + b);
    }
}

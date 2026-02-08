package scanner.ex;

public class ChangeVarEx {
    static void main(String[] args) {
        int a = 10;
        int b = 20;
        int temp;

        //시작 : 코드 작성
        temp = a;
        a = b;
        b = temp;
        //종료 : 코드 작성

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

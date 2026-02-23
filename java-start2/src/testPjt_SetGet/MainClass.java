package testPjt_SetGet;

public class MainClass {
    public static void main(String[] args) {

        Student student1 = new Student("홍길동", 90);
        student1.getInfo();

        student1.setScore(100);
        student1.getInfo();
    }
}

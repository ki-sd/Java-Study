package cond;

public class ScoreEx7 {
    static void main(String[] args) {
        int x = 49;

        String result = (x % 2 == 1) ? "홀수" : "짝수"; // x를 2로 나누었을때 나머지가 1이면 홀수, 아니면 짝수
        System.out.println("x = " + x + ", " + result);
    }
}

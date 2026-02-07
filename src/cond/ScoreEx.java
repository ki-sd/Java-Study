package cond;

public class ScoreEx {
    static void main(String[] args) {
        int score = 60;
        String result;

        if (score >= 90) {
            result = "A";
        }
        else if (score >= 80) {
            result = "B";
        }
        else if (score >= 70) {
            result = "C";
        }
        else if (score >= 60) {
            result = "D";
        } else {
            result = "F";
        }
        System.out.println("학점은 " + result + "입니다.");
    }
}

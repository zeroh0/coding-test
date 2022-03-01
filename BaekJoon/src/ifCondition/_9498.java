package ifCondition;

import java.util.Scanner;

public class _9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score;
        score = sc.nextInt();

        String out;
        if (score >= 90) {
            out = "A";
        } else if (score >= 80) {
            out = "B";
        } else if (score >= 70) {
            out = "C";
        } else if (score >= 60) {
            out = "D";
        } else {
            out = "F";
        }
        System.out.println(out);

        sc.close();
    }
}

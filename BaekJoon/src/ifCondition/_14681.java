package ifCondition;

import java.util.Scanner;

public class _14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y;
        x = sc.nextInt();
        y = sc.nextInt();

        String out;
        if (x > 0) {
            if (y > 0) {
                out = "1";
            } else {
                out = "4";
            }
        } else {
            if (y > 0) {
                out = "2";
            } else {
                out = "3";
            }
        }
        System.out.println(out);

        sc.close();
    }
}

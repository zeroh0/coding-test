package ifCondition;

import java.util.Scanner;

public class _1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();

        String out;
        if (a > b) {
            out = ">";
        } else if (a < b) {
            out = "<";
        } else {
            out = "==";
        }
        System.out.println(out);

        sc.close();
    }
}

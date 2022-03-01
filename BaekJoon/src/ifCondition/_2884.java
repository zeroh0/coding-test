package ifCondition;

import java.util.Scanner;

public class _2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int alarm = 45;
        int h, m;
        h = sc.nextInt();
        m = sc.nextInt();

        if (m - alarm >= 0) {
            m = m - alarm;
        } else {
            m = (m + 60) - alarm;
            if (h > 0) {
                h -= 1;
            } else {
                h = (h + 24) - 1;
            }
        }
        System.out.printf("%d %d", h, m);

        sc.close();
    }
}

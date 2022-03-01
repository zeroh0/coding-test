package ifCondition;

import java.util.Scanner;

public class _2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h, m, ct, ah;
        h = sc.nextInt();
        m = sc.nextInt();
        ct = sc.nextInt(); //cookingTime

        if (m + ct >= 60) {
            ah = (m + ct) / 60; // addHours
            m = (m + ct) % 60;
            h += ah;
            if (h >= 24) {
                h -= 24;
            }
        } else {
            m = m + ct;
        }
        System.out.printf("%d %d", h, m);

        sc.close();
    }
}

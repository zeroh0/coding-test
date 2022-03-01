package ifCondition;

import java.util.Scanner;

public class _2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int reward = 0;
        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if (a != b && b != c && a != c) {
            int max;
            if (a < b) {
                max = Math.max(b, c);
            } else {
                max = Math.max(a, c);
            }
            reward = max * 100;
        } else {
            if (a == b && b == c) {
                reward = 10000 + (a * 1000);
            } else {
                if(a == b) {
                    reward = 1000 + (a * 100);
                } else if (b == c) {
                    reward = 1000 + (b * 100);
                } else {
                    reward = 1000 + (c * 100);
                }
            }
        }
        System.out.println(reward);

        sc.close();
    }
}

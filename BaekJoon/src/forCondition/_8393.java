package forCondition;

import java.util.Scanner;

public class _8393 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int in;
        in = sc.nextInt();

        int tot = 0; // 합
        for (int i = 1; i <= in; i++) {
            tot += i;
        }
        System.out.println(tot);

        sc.close();
    }
}

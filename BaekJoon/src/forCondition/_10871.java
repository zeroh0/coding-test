package forCondition;

import java.util.Scanner;

public class _10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = sc.nextInt();
        }

        for (int o : in) {
            if (o < x) {
                System.out.print(o + " ");
            }
        }

        sc.close();
    }
}

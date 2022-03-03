package forCondition;

import java.util.Scanner;

public class _11021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int k = 0;
        int[][] in = new int[c][2];
        int[] out = new int[c];

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                in[i][j] = sc.nextInt();
                out[k] += in[i][j];
                if (j == (in[i].length-1)) {
                    k++;
                }
            }
        }

        for (int i = 0; i < out.length; i++) {
            System.out.printf("Case #%d: %d\n", (i + 1), out[i]);
        }

        sc.close();
    }
}

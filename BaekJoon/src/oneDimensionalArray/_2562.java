package oneDimensionalArray;

import java.util.Scanner;

public class _2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] d = new int[9];
        for (int i = 0; i < d.length; i++) {
            d[i] = sc.nextInt();
        }

        int index = 0; // 순서
        int max = 0; // 최대값 초기값
        for (int i = 0; i < d.length; i++) {
            if (max < d[i]) {
                max = d[i];
                index = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}



package oneDimensionalArray;

import java.util.Scanner;

public class _10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n개의 정수
        int[] d = new int[n];
        for (int i = 0; i < d.length; i++) {
            d[i] = sc.nextInt(); // n개의 정수 입력받기
        }

        int min = d[0]; // 최소값 초기값
        int max = d[0]; // 최대값 초기값
        for (int i : d) {
            if (max < i) {
                max = i;
            } else if (min > i) {
                min = i;
            }
        }

        System.out.println(min);
        System.out.println(max);
    }
}

package ioAndArithmethicOperactions;

import java.util.Scanner;

public class _2558 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, b1, b10, b100;
        a = sc.nextInt();
        b = sc.nextInt();

        b1 = b % 10; // 일의자리
        b10 = ((b % 100) - b1) / 10; // 십의자리
        b100 = ((b % 1000) - b10) / 100; // 백의자리

        System.out.println(a * b1);
        System.out.println(a * b10);
        System.out.println(a * b100);
        System.out.println(a * b);

        sc.close();
    }
}

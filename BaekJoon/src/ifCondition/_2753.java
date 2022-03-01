package ifCondition;

import java.util.Scanner;

public class _2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int in;
        in = sc.nextInt();

        if (in % 4 == 0 && (in % 100 != 0 || in % 400 == 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        sc.close();
    }
}

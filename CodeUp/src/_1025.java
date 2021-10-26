import java.util.ArrayList;
import java.util.Scanner;

public class _1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> arrNum = new ArrayList<>();
        while (num > 0) {
            arrNum.add(num % 10);
            num /= 10;
        }

        for (int i = arrNum.size() - 1; i >= 0; i--) {
            int digits;
            switch (i) {
                case 4:
                    digits = 10000;
                    break;
                case 3:
                    digits = 1000;
                    break;
                case 2:
                    digits = 100;
                    break;
                case 1:
                    digits = 10;
                    break;
                default:
                    digits = 1;
                    break;
            }
            System.out.println("[" + arrNum.get(i) * digits + "]");
        }
    }
}
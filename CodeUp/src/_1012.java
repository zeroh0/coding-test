import java.util.Scanner;

public class _1012 {
    public static void main (String[] args) {
        float n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextFloat();

        String str = String.format("%.6f", n);

        System.out.println(str);
    }
}

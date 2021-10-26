import java.util.Scanner;

public class _1015 {
    public static void main (String[] args) {
        float a;

        Scanner sc = new Scanner(System.in);

        a = sc.nextFloat();

        String str = String.format("%.2f", a);

        System.out.println(str);
    }
}
import java.util.Scanner;

public class _1067 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(a > 0 ? "plus" : "minus");
        System.out.println(a % 2 == 0 ? "even" : "odd");
    }
}

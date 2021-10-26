import java.util.Scanner;

public class _1090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int d = sc.nextInt();
        int n = sc.nextInt();
        for(int i=1; i<n; i++) {
            a *= d;
        }
        System.out.println(a);
    }
}

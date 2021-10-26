import java.util.Scanner;

public class _1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long h = sc.nextLong();
        long d = sc.nextLong();
        long c = sc.nextLong();
        long s = sc.nextLong();
        double save = (double)(h * d * c * s) / 8;
        double mb = (save / 1024) / 1024;
        System.out.printf("%.1f MB", mb);
    }
}

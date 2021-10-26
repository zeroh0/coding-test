import java.util.Scanner;

public class _1086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width  = sc.nextInt();
        int height  = sc.nextInt();
        int bit  = sc.nextInt();
        double save = (double)(width * height * bit) / 8;
        double mb = (save / 1024) / 1024;
        System.out.printf("%.2f MB", mb);
    }
}

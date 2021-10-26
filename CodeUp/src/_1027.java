import java.util.Scanner;

public class _1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cal = (sc.next()).split("\\.");
        int y = Integer.parseInt(cal[0]);
        int m = Integer.parseInt(cal[1]);
        int d = Integer.parseInt(cal[2]);
        System.out.printf("%02d-%02d-%04d", d, m, y);
    }
}

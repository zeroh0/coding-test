import java.util.Scanner;

public class _1035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String d = sc.next();
        int x = Integer.valueOf(d, 16);
        String o = Integer.toOctalString(x);
        System.out.println(o);
    }
}

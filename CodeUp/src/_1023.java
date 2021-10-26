import java.util.Scanner;

public class _1023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        d = Math.floor(d*1000000)/1000000.0;
        String str = String.valueOf(d);

        int i = str.indexOf(".");
        String a = str.substring(0, i);
        String b = str.substring(i+1);
        System.out.println(a);
        System.out.println(b);
    }
}
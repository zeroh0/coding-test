import java.util.Scanner;

public class _1082 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = Integer.parseInt(s, 16);
        for(int i=1; i<=Integer.parseInt("F", 16); i++) {
            System.out.println(s + "*" + Integer.toHexString(i).toUpperCase() + "=" + Integer.toHexString(n*i).toUpperCase());
        }
    }
}

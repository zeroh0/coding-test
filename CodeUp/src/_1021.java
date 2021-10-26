import java.util.Scanner;

public class _1021 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        char[] ch = str.toCharArray();
        for (int i = 0; i <= ch.length - 1; i++) {
            System.out.printf("%c", ch[i]);
        }
    }
}

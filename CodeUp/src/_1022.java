import java.util.Scanner;

public class _1022 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        char[] ch = str.toCharArray();
        for (int i = 0; i <= ch.length - 1; i++) {
            System.out.print(ch[i]);
        }

    }
}
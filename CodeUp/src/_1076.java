import java.util.Scanner;

public class _1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        char alpha = 'a';
        while(c >= alpha) {
            System.out.print(alpha + " ");
            alpha++;
        }
    }
}

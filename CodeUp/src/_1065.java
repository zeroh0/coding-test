import java.util.Scanner;

public class _1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[3];
        for(int a:n) {
            a = sc.nextInt();
            if(a % 2 == 0)
                System.out.println(a);
        }
    }
}

import java.util.Scanner;

public class _1080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i=0; i<=n; i++) {
            if((sum + i) >= n) {
                System.out.println(i);
                break;
            }
            sum += i;
        }
    }
}

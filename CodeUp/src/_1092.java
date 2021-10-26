import java.util.Scanner;

public class _1092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        int p3 = sc.nextInt();
        int day = 1;
        while(!(day%p1==0 && day%p2==0 && day%p3==0)) {
            day++;
        }
        System.out.println(day);
    }
}

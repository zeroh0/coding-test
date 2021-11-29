package greedy;

import java.util.Scanner;

public class UntilItBecomes1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n값과 k값 입력: ");
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;

        while(true) {
            int target = (n / k) * k;
            cnt += (n - target);
            n = target;

            if(n < k)
                break;

            n /= k;
            cnt += 1;
        }
        cnt += (n - 1);
        System.out.println(cnt);

        /*
        while (n != 1) {
            if (n % k == 0) {
                n /= k;
                cnt++;
            } else {
                n -= 1;
                cnt++;
                if (n % k == 0) {
                    n /= k;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        */

    }
}
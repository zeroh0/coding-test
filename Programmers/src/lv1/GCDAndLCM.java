package lv1;

// 최대공약수와 최소공배수
public class GCDAndLCM {
    public int[] solution(int n, int m) {
        int a = n;
        int b = m;

        /* 최대공약수 구하기 */
        int r = 0;
        while (m != 0) {
            r = n % m;
            n = m;
            m = r;
        }
        int gcd = n;
        int lcm = (a * b) / gcd; /* 최소공배수 구하기 */

        return new int[]{gcd, lcm};
    }
}

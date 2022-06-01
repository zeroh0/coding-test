package lv1;

// 정수 제곱근 판별
public class DeterminingIntegerSquareRoots {
    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);
        long pow = (long) Math.pow(sqrt, 2);

        if (n == pow) {
            return (sqrt + 1) * (sqrt + 1);
        } else {
            return -1;
        }
    }
}

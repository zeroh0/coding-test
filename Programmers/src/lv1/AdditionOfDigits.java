package lv1;

// 자릿수 더하기
public class AdditionOfDigits {
    public int solution(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
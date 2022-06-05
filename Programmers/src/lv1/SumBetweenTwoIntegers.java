package lv1;

// 두 정수 사이의 합
public class SumBetweenTwoIntegers {
    public long solution(int a, int b) {
        long answer = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (min == max) {
            return min;
        }
        for (int i = min; i <= max; i++) {
            answer += i;
        }
        return answer;
    }
}

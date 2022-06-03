package lv1;

// 소수 찾기
public class FindPrimeNumbers {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j <= n; j+=i) {
                arr[j] = 0; // 소수가 아니면 0
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                answer++;
            }
        }

        return answer;
    }
}

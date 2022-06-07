package lv1;

// 같은 숫자는 싫어
public class HateTheSameNumber {
    public int[] solution(int []arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                cnt++;
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = -1;
                } else break;
            }
        }

        int[] answer = new int[arr.length - cnt];

        cnt = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                j = cnt;
                if (arr[j] != -1) {
                    answer[i] = arr[j];
                    j = cnt++;
                    break;
                }
                j = cnt++;
            }
        }

        return answer;
    }
}

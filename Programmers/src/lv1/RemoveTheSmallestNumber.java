package lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 제일 작은 수 제거하기
public class RemoveTheSmallestNumber {
    public int[] solution(int[] arr) {
        if (arr.length > 1) {
            /* 최소값 구하기 */
            int index = 0;
            int min = arr[0]; // 최소값 초기값
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    index = i; // 최소값 인덱스
                }
            }

            /* int[] -> List<Integer> */
            List<Integer> out = Arrays.stream(arr).boxed().collect(Collectors.toList());
            out.remove(index);

            /* List<Integer> -> int[] */
            int[] answer = out.stream().mapToInt(Integer::intValue).toArray();

            return answer;
        } else {
            int[] error = new int[]{-1};

            return error;
        }
    }
}
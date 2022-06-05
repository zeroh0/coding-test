package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 나누어 떨어지는 숫자 배열
public class DivisibleArrayOfNumbers {
    public int[] solution1(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
                cnt++;
            }
        }

        if (cnt == 0) {
            return new int[]{-1};
        }

        list.sort(Comparator.naturalOrder());

        return list.stream().mapToInt(i -> i).toArray();
    }

    public int[] solution2(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).toArray();
        if (answer.length == 0) {
            return new int[]{-1};
        }
        Arrays.sort(answer);
        return answer;
    }

}

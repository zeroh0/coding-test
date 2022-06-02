package lv1;

// 자연수를 뒤집어 배열로 만들기
public class ReverseNaturalNumberToArray {
    public int[] solution(long n) {
        // long -> String -> char -> subtract ASCII code value of the character '0' (int value of character) -> array
        int[] input = Long.toString(n).chars().map(c -> c - '0').toArray();
        int[] answer = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int tmp = input[i];
            answer[i] = input[input.length - i - 1];
            input[i] = tmp;
        }
        return answer;
    }
}

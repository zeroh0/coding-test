package lv1;

// 하샤드 수
public class HarshadNumber {
    public boolean solution(int x) {
        boolean answer = true;
        char[] ch = ("" + x).toCharArray(); // int -> char[]
        int sum = 0;
        for (int i = 0; i < ch.length; i++) {
            sum += Character.getNumericValue(ch[i]); // char[] -> int
        }
        if (x % sum != 0) {
            answer = false;
        }
        return answer;
    }
}

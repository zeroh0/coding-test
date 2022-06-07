package lv1;

// 문자열 내 p와 y의 개수
public class NumberOfPAndYInTheString {
    boolean solution(String s) {
        boolean answer = true;

        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (String.valueOf(c).equalsIgnoreCase("p")) {
                p++;
            }
            if (String.valueOf(c).equalsIgnoreCase("y")) {
                y++;
            }
        }
        if (p != y) {
            answer = false;
        }

        return answer;
    }
}

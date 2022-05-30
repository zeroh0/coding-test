package lv1;

// 문자열 다루기 기본
public class StringHandlingBasic {
    public boolean solution(String s) {
        boolean answer = true;
        int sLength = s.length();
        if (sLength == 4 || sLength == 6) {
            for (int i = 0; i < sLength; i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    answer = false;
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }
}

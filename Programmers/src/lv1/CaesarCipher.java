package lv1;

import static java.lang.Character.*;

// 시저 암호
public class CaesarCipher {
    public String solution(String s, int n) {
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] != 32) { // 공백이 아닐 경우
                char tmp = cArr[i];
                cArr[i] += n;
                if (!isAlphabetic(cArr[i]) || isUpperCase(tmp) != isUpperCase(cArr[i])) { // 영문자가 아닐 경우 || 대소문자가 맞지 않을 경우
                    cArr[i] -= 26; // 증가된 아스키 코드 - 알파벳의 총 갯수
                }
            }
        }

        return String.valueOf(cArr);
    }
}

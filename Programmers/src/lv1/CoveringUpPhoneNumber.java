package lv1;

import java.util.Scanner;

// 핸드폰 번호 가리기
public class CoveringUpPhoneNumber {
    public String solution(String phone_number) {
        char[] answer = phone_number.toCharArray(); // String -> char[]
        for (int i = 0; i < answer.length - 4; i++) {
            answer[i] = '*';
        }
        return String.valueOf(answer); // char[] -> String
    }
}

package lv1;

import java.util.Scanner;

// 콜라츠 추측
public class DiscreteMathematics {
    public int solution(int num) {
        int cnt = 0;
        while (num != 1) {
            if (cnt >= 500) {
                num = -1;
                break;
            } else {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = (num * 3) + 1;
                }
                cnt++;
            }
        }
        return cnt;
    }
}

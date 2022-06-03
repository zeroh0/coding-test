package lv1;

// 수박수박수박수박수박수?
public class WatermelonClap {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        char[] watermelon = new char[]{'수', '박'};
        for (int i = 0, j = 0; i < n; i++, j++) {
            if (j > 1) j = 0;
            answer.append(watermelon[j]);
        }

        return String.valueOf(answer);
    }
}

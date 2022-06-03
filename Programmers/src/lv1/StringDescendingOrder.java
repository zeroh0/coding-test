package lv1;

// 문자열 내림차순으로 배치하기
public class StringDescendingOrder {
    public String solution(String s) {
        char tmp = 0;
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            for (int j = i + 1; j < cArr.length; j++) {
                if (cArr[i] < cArr[j]) {
                    tmp = cArr[i];
                    cArr[i] = cArr[j];
                    cArr[j] = tmp;
                }
            }
        }

        return String.valueOf(cArr);
    }
}

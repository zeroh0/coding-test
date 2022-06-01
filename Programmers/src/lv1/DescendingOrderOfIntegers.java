package lv1;

// 정수 내림차순으로 배치하기
public class DescendingOrderOfIntegers {
    public long solution(long n) {
        char[] arrayofNum = Long.toString(n).toCharArray();
        char tmp = 0;
        for (int i = 0; i < arrayofNum.length; i++) {
            for (int j = i + 1; j < arrayofNum.length; j++) {
                if (arrayofNum[i] < arrayofNum[j]) {
                    tmp = arrayofNum[i];
                    arrayofNum[i] = arrayofNum[j];
                    arrayofNum[j] = tmp;
                }
            }
        }

        return Long.parseLong(new String(arrayofNum));
    }
}

package lv1;

// 가운데 글자 가져오기
public class GetMiddleCharact {
    public String solution(String s) {
        int len = s.length();
        if (len % 2 == 0) {
            return s.substring(len / 2 - 1, len / 2 + 1);
        } else {
            return s.substring(len / 2, len / 2 + 1);
        }
    }
}

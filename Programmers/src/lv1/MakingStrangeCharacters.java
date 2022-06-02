package lv1;

import static java.lang.Character.*;

// 이상한 문자 만들기
public class MakingStrangeCharacters {
    public String solution(String s) {
        String[] split = s.split("\\s", -1);
        char[] chars;
        String[] arr = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            chars = split[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (j % 2 == 0) {
                    chars[j] = toUpperCase(chars[j]);
                } else {
                    chars[j] = toLowerCase(chars[j]);
                }
            }
            String str = String.valueOf(chars);
            arr[i] = str;
        }

        return String.join(" ", arr);
    }
}

package lv1;

import java.util.*;
import java.util.stream.Collectors;

// 문자열 내 마음대로 정렬하기
public class SortAsYouLikeString {
    public String[] solution(String[] strings, int n) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));

        List<String> collect = list.stream()
                .sorted((a, b) -> {
                    int compareTo = a.substring(n, n + 1).compareTo(b.substring(n, n + 1));
                    if (compareTo == 0) {
                        return a.compareTo(b);
                    } else {
                        return compareTo;
                    }
                })
                .collect(Collectors.toList());

        return collect.toArray(new String[0]);
    }
}

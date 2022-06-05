package lv1;

// 2016년
public class YearOf2016 {
    public String solution(int month, int day) {
        String[] dayOfTheWeek = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int year = 2016;
        if (month <= 2) {
            year -= 1;
            month += 12;
        }
        int y1 = year / 100; // 년도의 앞 두자리
        int y2 = year % 100; // 년도의 뒤 두자리

        // 제라의 공식
        int i = ((21 * y1 / 4) + (5 * y2 / 4) + (26 * (month + 1) / 10) + day - 1) % 7;

        return dayOfTheWeek[i];
    }
}

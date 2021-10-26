import java.util.Scanner;

public class _1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int h, m, s;

        String[] time = str.split(":");
        for (int i = 0; i < time.length; i++) {
            switch (i) {
                case 0:
                    h = Integer.parseInt(time[i]);
                    break;
                case 1:
                    m = Integer.parseInt(time[i]);
                    System.out.println(m);
                    break;
                case 2:
                    s = Integer.parseInt(time[i]);
                    break;
            }
        }
    }
}
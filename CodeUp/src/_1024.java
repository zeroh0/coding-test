import java.util.*;

public class _1024 {
    public static void main(String[] args) {
        char n = '\0';
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] c = str.toCharArray();

        for (int i=0; i<=c.length-1; i++) {
            System.out.println("\'" + c[i] + "\'");
        }

        int l = c.length;
        c = Arrays.copyOf(c, l + 1);
        c[l] = n;
    }
}
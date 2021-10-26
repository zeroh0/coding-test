import java.util.Scanner;

public class _1018 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int i = str.indexOf(":");

        String h = str.substring(0, i);
        String m = str.substring(i+1);

        System.out.printf("%s:%s", h ,m);
    }
}

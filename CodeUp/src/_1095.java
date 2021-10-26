import java.util.Scanner;

public class _1095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int min = 10000;
        for(int i=0; i<num.length; i++) {
            num[i] = sc.nextInt();
        }
        for(int i=0; i<num.length; i++) {
            if(min > num[i]) {
                min = num[i];
            }
        }
        System.out.println(min);
    }
}

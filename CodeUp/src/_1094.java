import java.util.Scanner;

public class _1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<num.length; i++)
            num[i] = sc.nextInt();
        for(int i= num.length-1; i>=0; i--) {
            System.out.print(num[i] + " ");
        }
    }
}

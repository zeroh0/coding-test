import java.util.Scanner;

public class _1093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] arr = new int[23];
        for(int i=0; i<num.length; i++)
            num[i] = sc.nextInt();
        for(int i=0; i<num.length; i++)
            arr[num[i]-1]++;
        for(int a:arr)
            System.out.print(a + " ");
    }
}

import java.util.Scanner;

public class _1084 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rgb = new int[3];
        for(int i=0; i<rgb.length; i++) {
            rgb[i] = sc.nextInt();
        }
        int cnt = 0;
        for(int i=0; i<rgb[0]; i++) {
            for(int j=0; j<rgb[1]; j++) {
                for(int k=0; k<rgb[2]; k++) {
                    System.out.printf("%d %d %d\n", i, j, k);
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}

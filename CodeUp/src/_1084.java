import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _1084 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] rgb = new int[3];
        for(int i=0; i<rgb.length; i++) {
            rgb[i] = sc.nextInt();
        }

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        for(int i=0; i<rgb[0]; i++) {
            for(int j=0; j<rgb[1]; j++) {
                for(int k=0; k<rgb[2]; k++) {
                    String st = i + " " + j + " " + k;
                    bf.write(st + "\n");
                    cnt++;
                }
            }
        }
        bf.write(String.valueOf(cnt));
        bf.close();
    }
}

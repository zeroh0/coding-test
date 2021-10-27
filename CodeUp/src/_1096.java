import java.util.Scanner;

public class _1096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = 2;

        int[][] in = new int[n1][n2];
        for(int i=0; i<in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                in[i][j] = sc.nextInt();
            }
        }

        int[][] board = new int[19][19];

        for(int i=0; i<in.length; i++) {
            board[in[i][0]-1][in[i][1]-1]++;
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}

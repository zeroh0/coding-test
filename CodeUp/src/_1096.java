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
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(i < n1 && j < n2) {
                    System.out.print(((board[in[i][j]-1][in[i][j]-1])++) + " ");
                } else {
                    System.out.print(board[i][j] + " ");
                }

            }
            System.out.println();
        }

    }
}

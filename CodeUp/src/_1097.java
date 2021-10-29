import java.util.Scanner;

public class _1097 {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[19][19];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        int n = scanner.nextInt();
        int[][] in = new int[n][n];
        for(int i=0; i<in.length; i++) {
            for(int j=0; j<in[i].length; j++) {
                in[i][j] = scanner.nextInt();
            }
        }

        /*
        in.length = 2, in[i].length = 2
        in[0][0] = 10, in[0][1] = 10
        in[1][1] = 12, in[1][1] = 12
        */

        //output
        for(int i=0; i<board.length; i++) {
            if(i < in.length) {
                if (board[i][in[i][1]] > 0) {
                    board[i][in[i][1]]--;
                } else {
                    board[i][in[i][1]]++;
                }
            }
            for(int j=0; j<board[i].length; j++) {
                if(i < in.length) {
                    if(board[in[i][0]-1][in[i][1]-1] > 0) {
                        board[in[i][0]-1][in[i][1]-1]--;
                    } else {
                        board[in[i][0]-1][in[i][1]-1]++;
                    }
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    } //main
}

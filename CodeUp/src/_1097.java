import java.util.Scanner;

public class _1097 {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[19][19];
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[i].length; j++)
                board[i][j] = scanner.nextInt();

        int n = scanner.nextInt();

        int[][] in = new int[n][2];
        for(int i=0; i<in.length; i++)
            for(int j=0; j<in[i].length; j++)
                in[i][j] = scanner.nextInt();

        //outputs
        int x = 0, y = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if (i < 2) {
                    x = in[i][0] - 1;
                    y = in[i][1] - 1;
                }
                if (board[i][y] == 1) {
                    board[i][y] = 5;
                }

                if (board[x][j] == 1) {
                    board[x][j] = 7;
                }
            }
        }

        for(int a[]:board) {
            for(int b:a) {
                System.out.print(b + "  ");
            }
            System.out.println();
        }

    } //main
}

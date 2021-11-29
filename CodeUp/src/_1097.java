import java.util.Scanner;

public class _1097 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* input */
        /* 한 줄씩 바둑판 상황 입력 받기 */
        int[][] board = new int[19][19];
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        /* 좌표 개수 입력받기 */
        int n = sc.nextInt();

        /* 좌표의 개수만큼 */
        int[][] xy = new int[n][2];

        for(int i=0; i<xy.length; i++) {
            for (int j = 0; j < xy[i].length; j++) {
                xy[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<xy.length; i++) {
            for (int j = 0; j < xy[i].length; j++) {
                for(int x=0; x<board.length; x++) {
                    if(board[xy[i][j]-1][x] == 0) board[xy[i][j]-1][x] = 1;
                    else board[xy[i][j]-1][x] = 0;
                }
                for(int x=0; x<board.length; x++) {
                    if(board[x][xy[i][j]-1] == 0) board[x][xy[i][j]-1] = 1;
                    else board[x][xy[i][j]-1] = 0;
                }
            }
        }

        /* output */
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    } //main
}

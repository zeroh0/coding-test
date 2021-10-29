import java.util.Scanner;

public class _1098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. board 크기 사용자 입력
        int[] size = new int[2];
        for(int i=0; i<size.length; i++)
            size[i] = sc.nextInt();

        // 2. 입력한 수만큼 값 입력가능
        int in = sc.nextInt();
        int[][] input = new int[in][4];
        for(int i=0; i<input.length; i++)
            for(int j=0; j<input.length; j++)
                input[i][j] = sc.nextInt();

        // 3. 입력한 값의 크기에 맞는 board 생성
        int[][] board = new int[size[0]][size[1]];

        System.out.println();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }

    } //main()
}

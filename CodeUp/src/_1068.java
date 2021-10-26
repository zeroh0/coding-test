import java.util.Scanner;

public class _1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        switch (score / 10) {
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
            case 7:
                System.out.println("B");
                break;
            case 6:
            case 5:
            case 4:
                System.out.println("C");
                break;
            default:
                System.out.println("D");
        }
    }
}

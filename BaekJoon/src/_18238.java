import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
    문제:
    2019년 12월, 두 번째로 개최된 ZOAC의 오프닝을 맡은 성우는 누구보다 화려하게 ZOAC를 알리려 한다.

    작년 ZOAC의 방식은 너무 식상하다고 생각한 성우는 문자열을 보여주는 새로운 규칙을 고안해냈다!

    규칙은 이러하다.
    - 그림과 같은 원판에 문자들이 순서대로 적혀있다. 처음 순간에 화살표는 'A'를 가리키고 있다.
    - 원판은 왼쪽 또는 오른쪽으로 돌릴 수 있다. 원판을 한 칸 돌리는 데에는 1의 시간이 소요된다.
    - 화살표가 가리키고 있는 문자를 출력할 수 있다. 문자를 출력하는 데에 걸리는 시간은 없다.
    시간이 너무 오래 걸리면 지루해할 ZOAC의 참가자들을 위해 성우는 해당 문자열을 앞에서부터 차례대로 최대한 빠르게 출력하려고 한다.

    바쁜 성우를 위하여 해당 문자열을 출력하는 데 걸리는 시간의 최솟값을 구해보자.

    입력:
    첫 번째 줄에 알파벳 대문자로 구성된 문자열이 주어진다. 문자열의 길이는 최대 100자이다. 빈 문자열은 주어지지 않는다.

    출력:
    입력으로 주어진 문자열을 출력하는 데에 걸리는 시간의 최솟값을 출력한다.

    예제 입력1:
    ZOAC

    예제 출력1:
    26

    예제 입력2:
    LBOLVUEEPMOIENMG

    예제 출력2:
    100
*/
public class _18238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray(); // 문자열 입력
        char[] alpha = {
                'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z'
        };
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
        // A B C D E F G H I J K  L  M  N  O  P  Q  L  S  T  U  V  W  X  Y  Z = 26
        final int HALF = 12;
        final int LAST = 25;
        int start = 0;

        int index = 0;
        for(char a:c) {
            index = Arrays.binarySearch(alpha, a);
            System.out.println(index);
        }

    } // main()
}

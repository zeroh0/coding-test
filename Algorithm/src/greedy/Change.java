package greedy;

public class Change {
    public static void main(String[] args) {
        int n = 1270;
        int cnt = 0;
        int[] coinArr = {500, 100, 50, 10};

        for(int i=0; i<coinArr.length; i++) {
            int coin = coinArr[i];
            cnt += n / coin;
            n %= coin;
        }
        System.out.println(cnt);
    }
}

package lv1;

// 평균 구하기
public class FindTheAverage {
    public double solutioin(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
}

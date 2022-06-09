package lecture.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Main_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (m == arr[mid]) {
                return mid + 1;
            } else if (arr[mid] < m) {
                start = mid + 1;
            } else if ((arr[mid] > m)) {
                end = mid - 1;
            }
        }
        return 0;
    }

}

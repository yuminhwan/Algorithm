package lecture.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Main_02 {

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
        int answer = 0;
        int left = Arrays.stream(arr)
            .max()
            .getAsInt();
        int right = Arrays.stream(arr)
            .sum();

        while (left <= right) {
            int mid = (left + right) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private static int count(int[] arr, int capacity) {
        int sum = 0;
        int cnt = 1;
        for (int x : arr) {
            if ((sum + x) <= capacity) {
                sum += x;
            } else {
                cnt++;
                sum = x;
            }
        }
        return cnt;
    }

}

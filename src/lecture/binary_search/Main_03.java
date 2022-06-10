package lecture.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Main_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, c, arr));
    }

    private static int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int left = 1;
        int right = arr[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (count(mid, arr) >= c) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static int count(int dist, int[] arr) {
        int ep = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= dist) {
                count++;
                ep = arr[i];
            }
        }

        return count;
    }

}

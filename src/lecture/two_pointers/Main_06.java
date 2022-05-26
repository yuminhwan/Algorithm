package lecture.two_pointers;

import java.util.Scanner;

public class Main_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution2(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int end = 0;
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (int start = 0; start < n; start++) {
            while (end < n && (k != 0 || arr[end] == 1)) {
                if (arr[end] == 0) {
                    k--;
                }
                cnt++;
                end++;
            }

            if (max < cnt) {
                max = cnt;
            }

            if (arr[start] == 0) {
                k++;
            }
            cnt--;
        }

        return max;
    }

    public static int solution2(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            if (arr[end] == 0) {
                cnt++;
            }

            while (cnt > k) {
                if (arr[start] == 0) {
                    cnt--;
                }
                start++;
            }

            answer = Math.max(answer, end - start + 1);
        }
        return answer;
    }

}

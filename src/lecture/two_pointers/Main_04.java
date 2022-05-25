package lecture.two_pointers;

import java.util.Scanner;

public class Main_04 {
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

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int end = 0;
        int sum = 0;
        for (int start = 0; start < n; start++) {
            // 연속부분수열의 합이 m보다 클때 까지 end를 증가시키면서 합을 구한다.
            while (end < n && sum < m) {
                sum += arr[end];
                end++;
            }

            // end이 n일때 sum이 m보다 작다면 확인할 필요가 없다.
            if (end == n && sum < m) {
                break;
            }

            // 합이 m과 같다면 카운트
            if (sum == m) {
                answer++;
            }

            // 이후 start를 빼주면서 부분수열을 확인
            sum -= arr[start];
        }
        return answer;
    }

    public static int solution2(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            sum += arr[end];

            // sum의 경우 항상 start~end까지의 합
            if (sum == m) {
                answer++;
            }

            while (sum >= m) {
                sum -= arr[start++];
                if (sum == m) {
                    answer++;
                }
            }
        }
        return answer;
    }

}

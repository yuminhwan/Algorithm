package lecture.two_pointers;

import java.util.Scanner;

public class Main_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution3(n));
    }

    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[(n / 2) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int end = 0;
        int sum = 0;
        for (int start = 0; start < arr.length; start++) {
            while (end < arr.length && sum < n) {
                sum += arr[end];
                end++;
            }

            if (sum == n) {
                answer++;
            }

            sum -= arr[start];
        }

        return answer;
    }

    public static int solution2(int n) {
        int answer = 0;
        int start = 0;
        int sum = 0;

        int length = (n / 2) + 1;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }

        for (int end = 0; end < length; end++) {
            sum += arr[end];

            if (sum == n) {
                answer++;
            }

            while (sum >= n) {
                sum -= arr[start++];
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static int solution3(int n) {
        int answer = 0;
        int cnt = 1;

        // n에서 1 빼기
        n--;
        while (n > 0) {
            // 처음에 cnt는 2로
            // 이후엔 하나씩 더하게 되니 연속된 자연수의 갯수를 뜻하게 됨
            cnt++;

            // n은 연속된 자연수 갯수들을 뺀 값
            // 1,2를 뺀 뒤 이후론 3, 4, 5 이렇게 빼줌
            n = n - cnt;

            // n % cnt == 0 일때가 연속된 자연수가 가능할 때
            if (n % cnt == 0) {
                answer++;
            }
        }

        return answer;
    }
}

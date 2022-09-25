import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(main.solution(N));
    }

    private int solution(int n) {
        int answer = 1;
        int[] arr = new int[10];

        while (n != 0) {
            arr[n % 10]++;
            n /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            answer = Math.max(answer, arr[i]);
        }

        answer = Math.max(answer, (arr[6] + arr[9] + 1) / 2);
        return answer;
    }
}

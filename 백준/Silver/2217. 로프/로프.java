import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(main.solution(N, arr));
    }

    private int solution(int n, int[] arr) {
        Arrays.sort(arr);

        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int result = (n - i) * arr[i];
            if (max < result) {
                max = result;
            }
        }
        return max;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(main.solution(arr));
    }

    static int n, k;

    private long solution(int[] arr) {
        long st = 1;
        long en = Integer.MAX_VALUE;
        while (st < en) {
            long mid = (st + en + 1) / 2;
            if (solve(arr, mid)) {
                st = mid;
            } else {
                en = mid - 1;
            }
        }
        return st;
    }

    private boolean solve(int[] arr, long x) {
        long count = 0;
        for (int i = 0; i < k; i++) {
            count += arr[i] / x;
        }
        return count >= n;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(main.solution(N, arr));
    }

    private String solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        int[] tmp = arr.clone();
        List<Integer> sorted = new ArrayList<>();

        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (i == 0 || tmp[i - 1] != tmp[i]) {
                sorted.add(tmp[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            int target = arr[i];
            sb.append(calculateIndex(sorted, target)).append(' ');
        }
        return sb.toString();
    }

    private int calculateIndex(List<Integer> arr, int target) {
        int st = 0;
        int en = arr.size();

        while (st < en) {
            int mid = (st + en) / 2;

            if (arr.get(mid) >= target) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}

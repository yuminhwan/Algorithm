import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int X = Integer.parseInt(br.readLine());
        System.out.println(main.solution(N, arr, X));
    }

    private int solution(int n, int[] arr, int x) {
        int answer = 0;
        boolean[] isExists = new boolean[2_000_000];
        for (int i = 0; i < n; i++) {
            if (x - arr[i] > 0 && isExists[x - arr[i]]) {
                answer++;
            }
            isExists[arr[i]] = true;
        }
        return answer;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(main.solution(N, K));
    }

    private int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[100_001];
        Arrays.fill(dist, -1);

        dist[n] = 0;
        q.add(n);

        while (dist[k] == -1) {
            int cur = q.remove();
            for (int next : new int[] {cur - 1, cur + 1, cur * 2}) {
                if (isValidRange(next) && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
        return dist[k];
    }

    private boolean isValidRange(int x) {
        return 0 <= x && x <= 100_000;
    }
}

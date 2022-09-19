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
        for (int x : main.solution(N, K)) {
            System.out.println(x);
        }
    }

    private int[] solution(int n, int k) {
        if (n >= k) {
            return new int[] {n - k, 1};
        }

        int[] dist = new int[100_001];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        dist[n] = 0;
        q.add(n);

        int minTime = Integer.MAX_VALUE;
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.remove();

            if (dist[cur] > minTime) {
                break;
            }

            for (int next : new int[] {cur + 1, cur - 1, cur * 2}) {
                if (isNotValidRange(next)) {
                    continue;
                }

                if (dist[next] != -1 && dist[next] != dist[cur] + 1) {
                    continue;
                }

                dist[next] = dist[cur] + 1;
                q.add(next);

                if (next == k) {
                    minTime = dist[next];
                    count++;
                }
            }
        }
        return new int[] {dist[k], count};
    }

    private boolean isNotValidRange(int x) {
        return x < 0 || 100_000 < x;
    }
}

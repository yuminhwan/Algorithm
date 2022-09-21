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

    private int solution(int start, int target) {
        int[] dist = new int[100_001];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.remove();

            int teleport = cur * 2;
            if (teleport <= 100_000 && dist[teleport] == -1) {
                dist[teleport] = dist[cur];
                q.add(teleport);
            }

            for (int next : new int[] {cur - 1, cur + 1}) {
                if (isNotValidRange(next) || dist[next] != -1) {
                    continue;
                }

                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        return dist[target];
    }

    private boolean isNotValidRange(int x) {
        return x < 0 || x > 100_000;
    }
}

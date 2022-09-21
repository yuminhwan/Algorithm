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
        int[] result = main.solution(N, K);
        System.out.println(result.length - 1);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    static final int MAX_SIZE = 100_001;

    private int[] solution(int n, int k) {
        int[] dist = new int[MAX_SIZE + 1];
        int[] past = new int[MAX_SIZE + 1];

        Arrays.fill(dist, -1);
        Arrays.fill(past, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        dist[n] = 0;

        while (dist[k] == -1) {
            int cur = q.remove();

            for (int next : new int[] {cur - 1, cur + 1, cur * 2}) {
                if (isNotValidRange(next) || dist[next] != -1) {
                    continue;
                }

                dist[next] = dist[cur] + 1;
                past[next] = cur;
                q.add(next);
            }
        }

        int minCount = dist[k];
        int[] answer = new int[minCount + 1];
        answer[0] = n;

        int pastIndex = k;
        for (int i = minCount; i > 0; i--) {
            answer[i] = pastIndex;
            pastIndex = past[pastIndex];
        }
        return answer;
    }

    private boolean isNotValidRange(int x) {
        return 0 > x || MAX_SIZE <= x;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> adj;
    static int[] deg;
    static int N, M;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        deg = new int[N + 1];
        adj = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj.get(start).add(end);
            deg[end]++;
        }

        for (int x : main.solution()) {
            System.out.print(x + " ");
        }
    }

    private List<Integer> solution() {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.remove();
            answer.add(cur);
            for (int next : adj.get(cur)) {
                deg[next]--;
                if (deg[next] == 0) {
                    q.add(next);
                }
            }
        }
        return answer;
    }
}

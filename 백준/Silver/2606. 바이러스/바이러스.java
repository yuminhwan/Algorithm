import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static List<Integer>[] adj;
    public static boolean[] visited;
    public static int N, M, V, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        V = 1;

        adj = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(cnt - 1);

    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        cnt = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            cnt++;

            for (int y : adj[x]) {
                if (visited[y]) {
                    continue;
                }

                q.add(y);
                visited[y] = true;
            }
        }
    }
}

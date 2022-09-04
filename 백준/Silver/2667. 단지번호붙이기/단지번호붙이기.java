import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static String[] adj;
    public static boolean[][] visited;
    public static int N, group_cnt;
    public static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static List<Integer> group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new String[N];
        for (int i = 0; i < N; i++) {
            adj[i] = br.readLine();
        }
        visited = new boolean[N][N];

        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && adj[i].charAt(j) == '1') {
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }

        Collections.sort(group);

        sb.append(group.size()).append("\n");
        for (int count : group) {
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        group_cnt++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];

            if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
                continue;
            }

            if (adj[dx].charAt(dy) == '0') {
                continue;
            }

            if (visited[dx][dy]) {
                continue;
            }
            dfs(dx, dy);
        }
    }

}

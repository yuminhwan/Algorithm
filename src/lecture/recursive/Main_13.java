package lecture.recursive;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main_13 {

    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] dis;
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adj[x].add(y);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(adj[i]);
        }

        bfs(1);
        for (int i = 2; i < n + 1; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    private static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        dis[start] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : adj[x]) {
                if (!visited[y]) {
                    visited[y] = true;
                    q.add(y);
                    dis[y] = dis[x] + 1;
                }
            }

        }
    }

}

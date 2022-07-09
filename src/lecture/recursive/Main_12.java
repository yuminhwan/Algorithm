package lecture.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_12 {

    static List<Integer>[] adj;
    static boolean[] vistied;
    static int n, m, answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
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

        vistied = new boolean[n + 1];
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int x) {
        vistied[x] = true;
        if (x == n) {
            answer++;
        } else {
            for (int y : adj[x]) {
                if (!vistied[y]) {
                    dfs(y);
                    vistied[y] = false;
                }
            }
        }
    }
}

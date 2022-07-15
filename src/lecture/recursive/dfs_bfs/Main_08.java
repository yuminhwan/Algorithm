package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_08 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static int n, f;
    public static int[][] dy;
    public static int[] b, pm;
    public static boolean[] visited;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        pm = new int[n];
        b = new int[n];
        visited = new boolean[n + 1];
        dy = new int[n][n];
        for (int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i);
        }
        dfs(0, 0);
    }

    public static void dfs(int L, int sum) {
        if (flag || sum > f) {
            return;
        }

        if (L == n) {
            if (sum == f) {
                for (int x : pm) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
        } else {
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    pm[L] = i;
                    dfs(L + 1, sum + (pm[L] * b[L]));
                    visited[i] = false;
                }
            }
        }
    }

    public static int combi(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

}

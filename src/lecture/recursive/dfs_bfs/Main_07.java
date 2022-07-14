package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_07 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static int n, r;
    public static int[][] dy;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        dy = new int[n + 1][r + 1];
        System.out.println(dfs(n, r));
    }

    private static int dfs(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        return dy[n][r] = dfs(n - 1, r) + dfs(n - 1, r - 1);
    }

}

package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_06 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static int n, m;
    public static int[] arr, pm;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pm = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
    }

    private static void dfs(int L) {
        if (L == m) {
            for (int x : pm) {
                System.out.printf(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    pm[L] = arr[i];
                    dfs(L + 1);
                    visited[i] = false;
                }
            }
        }
    }

}

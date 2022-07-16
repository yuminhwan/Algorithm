package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_09 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static int n, m;
    public static int[] pm;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];
        dfs(0, 1);
    }

    private static void dfs(int L, int start) {
        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < n + 1; i++) {
                pm[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

}

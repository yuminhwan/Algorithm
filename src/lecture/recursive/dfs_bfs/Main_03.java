package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_03 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static int n, m, answer = Integer.MIN_VALUE;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int L, int sum, int time) {
        if (time > m) {
            return;
        }
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(L + 1, sum + arr[L][0], time + arr[L][1]);
            dfs(L + 1, sum, time);
        }
    }

}

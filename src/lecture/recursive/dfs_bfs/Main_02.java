package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_02 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static int n, c, answer = Integer.MIN_VALUE;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int L, int sum) {
        if (sum > c) {
            return;
        }
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(L + 1, sum + arr[L]);
            dfs(L + 1, sum);
        }
    }

}

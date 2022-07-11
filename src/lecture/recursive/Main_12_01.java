package lecture.recursive;

import java.util.Scanner;

public class Main_12_01 {

    static int[][] adj;
    static boolean[] vistied;
    static int n, m, answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        adj = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adj[x][y] = 1;
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
            for (int y = 1; y < n + 1; y++) {
                if (adj[x][y] == 1 && !vistied[y]) {
                    dfs(y);
                    vistied[y] = false;
                }
            }
        }
    }
}

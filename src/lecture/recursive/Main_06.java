package lecture.recursive;

import java.util.Scanner;

public class Main_06 {

    static int n;
    static boolean[] vistied;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        vistied = new boolean[n + 1];
        dfs(1);
    }

    private static void dfs(int L) {
        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (vistied[i]) {
                    sb.append(i).append(" ");
                }
            }
            if (sb.length() > 0) {
                System.out.println(sb);
            }
            return;
        }
        vistied[L] = true;
        dfs(L + 1);
        vistied[L] = false;
        dfs(L + 1);
    }

}

package lecture.recursive;

import java.util.Scanner;

public class Main_04 {

    static int[] fibo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fibo = new int[n + 1];
        dfs4(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    private static int dfs(int n) {
        if (n <= 2) {
            return fibo[n] = 1;
        }
        return fibo[n] = dfs(n - 2) + dfs(n - 1);
    }

    private static int dfs2(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }

        if (n <= 2) {
            return fibo[n] = 1;
        }
        return fibo[n] = dfs2(n - 2) + dfs2(n - 1);
    }

    private static void dfs3(int n) {
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
    }

    private static int dfs4(int n) {
        if (n <= 2) {
            return 1;
        }
        return dfs4(n - 1) + dfs4(n - 2);
    }

}

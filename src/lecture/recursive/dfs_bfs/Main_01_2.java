package lecture.recursive.dfs_bfs;

import java.io.IOException;
import java.util.Scanner;

public class Main_01_2 {

    static String answer = "NO";
    static int n, total;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];
        }
        dfs(0, 0, arr);
        System.out.println(answer);
    }

    private static void dfs(int L, int sum, int[] arr) {
        if (flag || sum > total / 2) {
            return;
        }
        if (L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(L + 1, sum + arr[L], arr); // visited = true
            dfs(L + 1, sum, arr);                // visited = false
        }
    }

}

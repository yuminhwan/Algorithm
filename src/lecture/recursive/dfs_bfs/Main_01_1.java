package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_01_1 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static boolean[] vistied;
    public static String answer = "NO";
    public static int[] arr;
    public static int n, total;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1];
        vistied = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int x) {
        if (x == n) {
            int sum = calculateSum();
            if (sum * 2 == total) {
                answer = "YES";
            }
        } else {
            vistied[x] = true;
            dfs(x + 1);
            vistied[x] = false;
            dfs(x + 1);
        }
    }

    private static int calculateSum() {
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            if (vistied[i]) {
                sum += arr[i];
            }
        }
        return sum;
    }

}

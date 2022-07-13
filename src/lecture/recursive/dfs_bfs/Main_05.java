package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_05 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static int n, m, answer = Integer.MAX_VALUE;
    public static int[] coins;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        coins = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(bf.readLine());
        dfs(0, 0);
        System.out.println(answer);
        System.out.println(bfs());
    }

    private static void dfs(int L, int sum) {
        if (sum > m || L >= answer) {
            return;
        }
        if (sum == m) {
            answer = Math.min(Main.answer, L);
        } else {
            for (int i = n - 1; i >= 0; i--) {
                dfs(L + 1, sum + coins[i]);
            }
        }
    }

    private static int bfs() {
        int answer = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            deque.add(coins[i]);
        }
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                int change = deque.remove();
                for (int coin : coins) {
                    int sum = change + coin;
                    if (sum == m) {
                        return answer + 1;
                    } else {
                        deque.add(sum);
                    }
                }
            }
            answer++;
        }
        return answer;
    }

}

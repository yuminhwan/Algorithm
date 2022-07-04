package lecture.recursive;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_08 {

    static boolean[] visited;
    static int[] dis = {1, -1, 5};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        System.out.println(bfs(s, e));
    }

    private static int bfs(int s, int e) {
        Deque<Integer> q = new ArrayDeque<>();
        visited = new boolean[10_001];
        visited[s] = true;
        int answer = 1;
        q.add(s);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int result = q.remove();
                for (int x : dis) {
                    int next = result + x;
                    if (next == e) {
                        return answer;
                    }
                    if (1 <= next && next <= 10_000 && !visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            answer++;
        }
        return answer;
    }

}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        System.out.println(main.solution(N, K));
    }

    public int solution(int N, int K) {
        if (N == K) {
            return 0;
        }

        boolean[] visited = new boolean[100_001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;
        int answer = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int result = queue.remove();
                for (int j = 0; j < 3; j++) {
                    int next = move(j, result);
                    if (next == K) {
                        return answer;
                    }

                    if (0 <= next && next <= 100_000 && !visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    private int move(int index, int value) {
        if (index == 0) {
            return value - 1;
        } else if (index == 1) {
            return value + 1;
        } else {
            return value * 2;
        }
    }
}

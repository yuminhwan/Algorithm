import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        System.out.println(main.solution());
    }

    static int N = 5, answer;
    static char[][] board;
    static int[] selected;
    static boolean[] visited, adjVisited;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int solution() {
        visited = new boolean[N * N];
        selected = new int[7];
        find(0, 0, 0);
        return answer;
    }

    private void find(int start, int level, int dasomCount) {
        if (level == 7) {
            if (dasomCount >= 4) {
                if (isAllAdj()) {
                    answer++;
                }
            }
            return;
        }

        for (int i = start; i < N * N; i++) {
            visited[i] = true;
            selected[level] = i;
            if (board[i / N][i % N] == 'S') {
                find(i + 1, level + 1, dasomCount + 1);
            } else {
                find(i + 1, level + 1, dasomCount);
            }
            visited[i] = false;
        }
    }

    private boolean isAllAdj() {
        int count = 1;
        adjVisited = new boolean[N * N];
        Queue<Integer> q = new LinkedList<>();
        int start = selected[0];
        adjVisited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.remove();

            for (int i = 0; i < 4; i++) {
                int dx = (cur / N) + move[i][0];
                int dy = (cur % N) + move[i][1];
                int convertIndex = dx * N + dy;

                if (isNotValidRange(dx, dy) || adjVisited[convertIndex] || !visited[convertIndex]) {
                    continue;
                }

                count++;
                adjVisited[convertIndex] = true;
                q.add(convertIndex);
            }
        }

        return count == 7;
    }

    private boolean isNotValidRange(int x, int y) {
        return 0 > x || 0 > y || N <= x || N <= y;
    }
}

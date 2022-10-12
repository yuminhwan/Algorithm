import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[N][N];
        colors = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        main.solution(0, 0, N);
        for (int x : colors) {
            System.out.println(x);
        }
    }

    static int N;
    static int[][] board;
    static int[] colors;

    private void solution(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            colors[board[x][y] + 1]++;
            return;
        }

        int n = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution(x + i * n, y + j * n, n);
            }
        }
    }

    private boolean isSameColor(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[x][y] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

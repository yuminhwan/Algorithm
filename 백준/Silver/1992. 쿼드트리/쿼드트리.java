import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
        main.solution(0, 0, N);
        System.out.println(sb.toString());
    }

    static int N;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    private void solution(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            sb.append(board[x][y]);
            return;
        }

        sb.append('(');
        int n = size / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solution(x + i * n, y + j * n, n);
            }
        }
        sb.append(')');
    }

    private boolean isSameColor(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[x][y] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

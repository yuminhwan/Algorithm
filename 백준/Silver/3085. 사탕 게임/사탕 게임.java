import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        System.out.println(main.solution());
    }

    private int solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swapRow(i, j);
                calculateMax();
                swapRow(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swapCol(i, j);
                calculateMax();
                swapCol(i, j);
            }
        }
        return max;
    }

    private void swapCol(int i, int j) {
        char temp = board[j][i];
        board[j][i] = board[j + 1][i];
        board[j + 1][i] = temp;
    }

    private void swapRow(int i, int j) {
        char temp = board[i][j];
        board[i][j] = board[i][j + 1];
        board[i][j + 1] = temp;
    }

    private void calculateMax() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }
    }
}

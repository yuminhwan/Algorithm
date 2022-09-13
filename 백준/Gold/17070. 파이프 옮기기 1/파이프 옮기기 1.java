import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] adj;
    static int answer;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        adj = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        main.solution(1, 2, 0);
        System.out.println(answer);
    }

    private void solution(int x, int y, int direction) {
        if (x == N && y == N) {
            answer++;
            return;
        }

        switch (direction) {
            case 0: // 가로일때
                moveRight(x, y);
                break;
            case 1:  // 세로일때
                moveDown(x, y);
                break;
            case 2: // 대각선일때
                moveRight(x, y);
                moveDown(x, y);
                break;
        }
        moveDiagonal(x, y);
    }

    private void moveDiagonal(int x, int y) {
        if (x + 1 <= N && y + 1 <= N && adj[x + 1][y] == 0 && adj[x][y + 1] == 0 && adj[x + 1][y + 1] == 0) {
            solution(x + 1, y + 1, 2);
        }
    }

    private void moveDown(int x, int y) {
        int dx = x + 1;
        if (dx <= N && adj[dx][y] == 0) {
            solution(dx, y, 1);
        }
    }

    private void moveRight(int x, int y) {
        int ny = y + 1;
        if (ny <= N && adj[x][ny] == 0) {
            solution(x, ny, 0);
        }
    }

}

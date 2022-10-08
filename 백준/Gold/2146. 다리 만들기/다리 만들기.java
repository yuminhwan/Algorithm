import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(main.solution());
    }

    static int N;
    static int[][] board, dist;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    private int solution() {
        int landNumber = 0;
        dist = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                landNumber++;
                insertLandNumber(landNumber, i, j);
            }
        }

        initDist();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                Queue<Location> q = new LinkedList<>();
                q.add(new Location(i, j));
                dist[i][j] = 0;
                boolean isEscape = false;
                while (!q.isEmpty() && !isEscape) {
                    Location cur = q.remove();

                    for (int dir = 0; dir < 4; dir++) {
                        int dx = cur.x + move[dir][0];
                        int dy = cur.y + move[dir][1];

                        if (isNotValidRange(dx, dy) || dist[dx][dy] != -1 || board[dx][dy] == board[i][j]) {
                            continue;
                        }

                        if (board[dx][dy] != 0 && board[dx][dy] != board[i][j]) {
                            answer = Math.min(answer, dist[cur.x][cur.y]);
                            isEscape = true;
                            break;
                        }
                        dist[dx][dy] = dist[cur.x][cur.y] + 1;
                        q.add(new Location(dx, dy));
                    }
                }
                initDist();
            }
        }
        return answer;
    }

    private void initDist() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
    }

    private void insertLandNumber(int landNumber, int i, int j) {
        Queue<Location> q = new LinkedList<>();
        visited[i][j] = true;
        board[i][j] = landNumber;
        q.add(new Location(i, j));
        while (!q.isEmpty()) {
            Location cur = q.remove();

            for (int dir = 0; dir < 4; dir++) {
                int dx = cur.x + move[dir][0];
                int dy = cur.y + move[dir][1];

                if (isNotValidRange(dx, dy) || visited[dx][dy] || board[dx][dy] == 0) {
                    continue;
                }

                board[dx][dy] = landNumber;
                visited[dx][dy] = true;
                q.add(new Location(dx, dy));
            }
        }
    }

    private boolean isNotValidRange(int x, int y) {
        return 0 > x || 0 > y || x >= N || y >= N;
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

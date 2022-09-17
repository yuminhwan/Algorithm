import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        System.out.println(main.solution());
    }

    static int N, answer;
    static boolean[] visitedWidth, visitedDownCross, visitedUpCross;

    private int solution() {
        visitedWidth = new boolean[N];
        visitedDownCross = new boolean[2 * N - 1];
        visitedUpCross = new boolean[2 * N - 1];

        dfs(0);
        return answer;
    }

    private void dfs(int x) {
        if (x == N) {
            answer++;
            return;
        }

        for (int y = 0; y < N; y++) {
            if (!visitedWidth[y] && !visitedDownCross[x + y] && !visitedUpCross[x - y + N - 1]) {
                visitedAll(x, y, true);
                dfs(x + 1);
                visitedAll(x, y, false);
            }
        }
    }

    private void visitedAll(int x, int y, boolean isVisited) {
        visitedWidth[y] = isVisited;
        visitedDownCross[x + y] = isVisited;
        visitedUpCross[x - y + N - 1] = isVisited;
    }
}

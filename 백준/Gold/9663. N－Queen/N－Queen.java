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

        for (int dy = 0; dy < N; dy++) {
            int downCross = x + dy;
            int upCross = x - dy + N - 1;
            if (!visitedWidth[dy] && !visitedDownCross[downCross] && !visitedUpCross[upCross]) {
                visitedWidth[dy] = true;
                visitedDownCross[downCross] = true;
                visitedUpCross[upCross] = true;
                dfs(x + 1);
                visitedWidth[dy] = false;
                visitedDownCross[downCross] = false;
                visitedUpCross[upCross] = false;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(main.solution());
    }

    static int N, brokenCount, answer = Integer.MIN_VALUE;
    static int[][] eggs;

    private int solution() {
        dfs(0);
        return answer;
    }

    private void dfs(int start) {
        if (start == N) {
            answer = Math.max(answer, brokenCount);
            return;
        }

        if (eggs[start][0] <= 0 || brokenCount == N - 1) {
            dfs(start + 1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == start || eggs[i][0] <= 0) {
                continue;
            }

            eggs[start][0] -= eggs[i][1];
            eggs[i][0] -= eggs[start][1];
            if (eggs[start][0] <= 0) {
                brokenCount++;
            }
            if (eggs[i][0] <= 0) {
                brokenCount++;
            }

            dfs(start + 1);
            
            if (eggs[start][0] <= 0) {
                brokenCount--;
            }
            if (eggs[i][0] <= 0) {
                brokenCount--;
            }
            eggs[start][0] += eggs[i][1];
            eggs[i][0] += eggs[start][1];
        }
    }
}

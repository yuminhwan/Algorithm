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
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(main.solution());
    }

    static int N, S, answer;
    static int[] nums;

    private int solution() {
        dfs(0, 0);
        if (S == 0) {
            answer--;
        }
        return answer;
    }

    private void dfs(int level, int sum) {
        if (level == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }
        dfs(level + 1, sum);
        dfs(level + 1, sum + nums[level]);
    }
}

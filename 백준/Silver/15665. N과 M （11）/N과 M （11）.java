import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }
        arr = set.stream()
            .mapToInt(i -> i)
            .toArray();
        N = arr.length;
        System.out.println(main.solution());
    }

    static int N, M;
    static int[] arr, pm;
    static StringBuilder sb = new StringBuilder();

    private String solution() {
        pm = new int[M];
        Arrays.sort(arr);

        dfs(0);
        return sb.toString();
    }

    private void dfs(int level) {
        if (level == M) {
            for (int x : pm) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            pm[level] = arr[i];
            dfs(level + 1);
        }
    }
}

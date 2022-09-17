import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());

        System.out.println(main.solution(K));
    }

    static StringBuilder sb = new StringBuilder();

    private String solution(int k) {
        sb.append((1 << k) - 1).append("\n");
        func(1, 3, k);
        return sb.toString();
    }

    private void func(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        func(a, 6 - a - b, n - 1);
        sb.append(a).append(" ").append(b).append("\n");
        func(6 - a - b, b, n - 1);
    }
}

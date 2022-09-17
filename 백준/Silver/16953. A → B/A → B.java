import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        System.out.println(main.solution(A, B));
    }

    static long target;

    private int solution(long a, long b) {
        target = b;
        return bfs(a);
    }

    private int bfs(long start) {
        Queue<Long> q = new LinkedList<>();
        q.add(start);

        int cnt = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                long cur = q.remove();
                for (long next : new long[] {cur * 2, (cur * 10) + 1}) {
                    if (isValidRange(next)) {
                        if (next == target) {
                            return cnt + 2;
                        }
                        q.add(next);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    private boolean isValidRange(long x) {
        return 1 <= x && x <= target;
    }
}

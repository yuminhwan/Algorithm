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
        int N = Integer.parseInt(st.nextToken());
        System.out.println(main.solution(N));
    }

    static boolean[][] visited;

    private int solution(int target) {
        visited = new boolean[1001][1001];
        Queue<Emoji> q = new LinkedList<>();
        q.add(new Emoji(1, 0, 0));

        while (!q.isEmpty()) {
            Emoji cur = q.remove();

            int emojiCount = cur.count;
            int copyCount = cur.copyCount;
            int time = cur.time;

            if (emojiCount == target) {
                return time;
            }

            if (emojiCount > 0 && !visited[emojiCount][emojiCount]) {
                visited[emojiCount][copyCount] = true;
                q.add(new Emoji(emojiCount, emojiCount, time + 1));
            }

            if (copyCount > 0 && emojiCount + copyCount <= 1000 && !visited[emojiCount + copyCount][copyCount]) {
                visited[emojiCount + copyCount][copyCount] = true;
                q.add(new Emoji(emojiCount + copyCount, copyCount, time + 1));
            }

            if (emojiCount - 1 >= 0 && !visited[emojiCount - 1][copyCount]) {
                visited[emojiCount - 1][copyCount] = true;
                q.add(new Emoji(emojiCount - 1, copyCount, time + 1));
            }
        }
        return -1;
    }

    private boolean isValidRange(int count) {
        return 0 < count && count < 2000;
    }

    static class Emoji {
        int count;
        int copyCount;
        int time;

        public Emoji(int count, int copyCount, int time) {
            this.count = count;
            this.copyCount = copyCount;
            this.time = time;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int x : main.solution(N, arr)) {
            System.out.print(x + " ");
        }
    }

    private int[] solution(int n, int[] arr) {
        int[] answer = new int[n];

        Deque<Laser> lasers = new ArrayDeque<>();
        Deque<Laser> nonReceiveLasers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            lasers.add(new Laser(arr[i], i + 1));
        }

        while (!lasers.isEmpty()) {
            Laser laser = lasers.removeLast();

            while (!nonReceiveLasers.isEmpty() && nonReceiveLasers.peekLast().height <= laser.height) {
                Laser receiveLaser = nonReceiveLasers.removeLast();
                answer[receiveLaser.index - 1] = laser.index;
            }
            nonReceiveLasers.add(laser);
        }

        return answer;
    }

    static class Laser {
        int height;
        int index;

        public Laser(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}

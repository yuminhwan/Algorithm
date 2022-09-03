import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int n = Integer.parseInt(br.readLine());

            int cnt = 0;

            sb.append(((n + 1) / 2)).append("\n");
            for (int i = 0; i < n; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine(), " ");
                }

                int val = Integer.parseInt(st.nextToken());

                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.add(val);
                } else {
                    minHeap.add(val);
                }

                if (!minHeap.isEmpty()) {
                    if (maxHeap.peek() > minHeap.peek()) {
                        int t1 = maxHeap.poll();
                        int t2 = minHeap.poll();

                        maxHeap.add(t2);
                        minHeap.add(t1);
                    }
                }

                if (i % 2 == 0) {
                    if (cnt == 9 || i == n - 1) {
                        sb.append(maxHeap.peek()).append("\n");
                        cnt = 0;
                    } else {
                        sb.append(maxHeap.peek()).append(" ");
                    }
                    cnt++;
                }
            }
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<List<Node>> adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());

        System.out.println(solution(startPos, endPos));
    }

    private static int solution(int startPos, int endPos) {
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        pq.add(new Node(startPos, 0));

        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node curNode = pq.remove();
            int cur = curNode.end;
            int curValue = curNode.weight;

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (curValue > dist[cur]) {
                continue;
            }

            // 현재 노드와 연결된 다른 입접한 노드들 확인
            for (Node node : adj.get(cur)) {
                int cost = curValue + node.weight;
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우 갱신 후 큐에 저장
                if (dist[node.end] > cost) {
                    dist[node.end] = cost;
                    pq.add(new Node(node.end, cost));
                }
            }
        }
        return dist[endPos];
    }

    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }
}

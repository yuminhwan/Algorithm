import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static List<Edge> adj;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj.add(new Edge(start, end, cost));
        }
        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;
        int count = 0;

        // 제일 낮은 비용의 간선을 선택하기 위해 정렬
        adj.sort(Comparator.comparingInt(Edge::getCost));

        // 간선을 반복하며 확인
        for (Edge edge : adj) {
            int cost = edge.cost;
            int a = edge.start;
            int b = edge.end;

            // 같은 그룹이 아니라면 같은 그룹으로 만듬
            if (find(a) != find(b)) {
                union(a, b);
                answer += cost;
            }

            // 최소 신장 트리를 완성했다면 break 
            if (count == V - 1) {
                break;
            }
        }
        return answer;
    }

    public static int find(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }
    }
}

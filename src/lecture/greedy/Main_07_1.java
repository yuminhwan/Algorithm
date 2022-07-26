package lecture.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_07_1 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static List<Edge>[] adj;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		adj = new ArrayList[v + 1];
		for (int i = 0; i < v + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		visited = new boolean[v + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b, c));
			adj[b].add(new Edge(a, c));
		}

		System.out.println(prim());
	}

	private static int prim() {
		int answer = 0;
		Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getDistance));
		pq.add(new Edge(1, 0));

		while (!pq.isEmpty()) {
			Edge now = pq.remove();
			int next = now.next;
			if (!visited[next]) {
				visited[next] = true;
				answer += now.distance;
				for (Edge edge : adj[next]) {
					if (!visited[edge.next]) {
						pq.add(new Edge(edge.next, edge.distance));
					}
				}
			}
		}
		return answer;
	}

	static class Edge {
		private final int next;
		private final int distance;

		public Edge(int next, int distance) {
			this.next = next;
			this.distance = distance;
		}

		public int getDistance() {
			return distance;
		}
	}

}

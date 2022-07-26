package lecture.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_07 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static int[] parent;
	public static List<Edge> edges;
	public static int v, e;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parent = new int[v + 1];
		edges = new ArrayList<>();
		for (int i = 1; i < v + 1; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			edges.add(new Edge(from, to, distance));
		}

		edges.sort(Comparator.comparingInt(Edge::getDistance));

		System.out.println(kruskal());
		bf.close();
	}

	private static int kruskal() {
		int answer = 0;
		int count = 0;
		for (Edge edge : edges) {
			int cost = edge.distance;
			int a = edge.nodeB;
			int b = edge.nodeA;

			if (find(a) != find(b)) {
				union(a, b);
				answer += cost;
				count++;
				if (count == v - 1) {
					break;
				}
			}
		}
		return answer;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a > b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	private static int find(int v) {
		if (parent[v] == v) {
			return v;
		}
		return parent[v] = find(parent[v]);
	}

	static class Edge {
		private final int nodeA;
		private final int nodeB;
		private final int distance;

		public Edge(int nodeA, int nodeB, int distance) {
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.distance = distance;
		}

		public int getDistance() {
			return distance;
		}
	}

}

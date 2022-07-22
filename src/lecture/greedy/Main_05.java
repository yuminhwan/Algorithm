package lecture.greedy;

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

public class Main_05 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static int n, m;
	public static List<Node>[] adj;
	public static int[] distance;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		distance = new int[n + 1];
		visited = new boolean[n + 1];

		adj = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			adj[from].add(new Node(to, value));
		}

		Arrays.fill(distance, Integer.MAX_VALUE);

		solution2(1);
		for (int i = 2; i < n + 1; i++) {
			System.out.print(i + " : ");
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("impossible");
				continue;
			}
			System.out.println(distance[i]);
		}
		bf.close();
	}

	private static void solution(int start) {
		distance[start] = 0;
		visited[start] = true;

		for (int i = 0; i < adj[start].size(); i++) {
			distance[adj[start].get(i).to] = adj[start].get(i).value;
		}

		for (int i = 0; i < n - 1; i++) {
			int minIndex = getSmallestNode();

			visited[minIndex] = true;
			for (int j = 0; j < adj[minIndex].size(); j++) {
				int cost = distance[minIndex] + adj[minIndex].get(j).value;
				if (cost < distance[adj[minIndex].get(j).to]) {
					distance[adj[minIndex].get(j).to] = cost;
				}
			}
		}
	}

	private static void solution2(int start) {
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getValue));
		pq.add(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.remove();
			int now = node.to;
			int nowValue = node.value;
			if (nowValue > distance[now]) {
				continue;
			}
			for (Node ob : adj[now]) {
				if (distance[ob.to] > nowValue + ob.value) {
					distance[ob.to] = nowValue + ob.value;
					pq.add(new Node(ob.to, nowValue + ob.value));
				}
			}
		}
	}

	private static int getSmallestNode() {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;

		for (int j = 1; j < n + 1; j++) {
			if (!visited[j] && distance[j] < min) {
				min = distance[j];
				minIndex = j;
			}
		}
		return minIndex;
	}

	static class Node {
		int to;
		int value;

		public Node(int to, int value) {
			this.to = to;
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

}

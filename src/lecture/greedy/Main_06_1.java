package lecture.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_06_1 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static int[] unf;
	public static int[] rank;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		unf = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			unf[i] = i;
			rank[i] = 1;
		}
		for (int i = 1; i < m + 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		st = new StringTokenizer(bf.readLine());
		int fa = find(Integer.parseInt(st.nextToken()));
		int fb = find(Integer.parseInt(st.nextToken()));
		if (fa == fb) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		bf.close();
	}

	private static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);

		if (fa == fb) {
			return;
		}

		if (rank[a] > rank[b]) {
			unf[b] = a;
			rank[a] += rank[b];
		} else {
			unf[a] = b;
			rank[b] += rank[a];
		}
	}

	private static int find(int v) {
		if (v == unf[v]) {
			return v;
		}
		return unf[v] = find(unf[v]);
	}

}

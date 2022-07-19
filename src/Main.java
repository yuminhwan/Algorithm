import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static int n, m, len, answer = Integer.MAX_VALUE;
	public static int[] combi;
	public static boolean[] visited;
	public static List<Point> pizzas, houses;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		pizzas = new ArrayList<>();
		houses = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 2) {
					pizzas.add(new Point(i, j));
				} else if (tmp == 1) {
					houses.add(new Point(i, j));
				}
			}
		}
		len = pizzas.size();
		combi = new int[m];
		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int L, int s) {
		if (L == m) {
			int sum = 0;
			for (Point house : houses) {
				int dis = Integer.MAX_VALUE;
				for (int x : combi) {
					Point pizza = pizzas.get(x);
					int nx = Math.abs(house.x - pizza.x);
					int ny = Math.abs(house.y - pizza.y);
					dis = Math.min(dis, nx + ny);
				}
				sum += dis;
			}
			answer = Math.min(answer, sum);
		} else {
			for (int i = s; i < len; i++) {
				combi[L] = i;
				dfs(L + 1, i + 1);
			}
		}
	}

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}

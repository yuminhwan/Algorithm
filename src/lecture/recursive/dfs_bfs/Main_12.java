package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_12 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static int[][] box, dis;
	public static int n, m;
	public static Deque<Point> deque = new ArrayDeque<>();
	public static int[][] move = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		dis = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					deque.add(new Point(i, j));
					// 출발점이 여러개 이다. -> 모두 다 0레벨이다.
				}
			}
		}

		bfs();
		boolean success = true;
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					success = false;
					break;
				}
			}
		}

		if (success) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					answer = Math.max(answer, dis[i][j]);
				}
			}
		} else {
			answer = -1;
		}

		System.out.println(answer);
	}

	private static void bfs() {
		while (!deque.isEmpty()) {
			Point point = deque.remove();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + move[i][0];
				int ny = point.y + move[i][1];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx][ny] == 0) {
					box[nx][ny] = 1;
					deque.add(new Point(nx, ny));
					dis[nx][ny] = dis[point.x][point.y] + 1;
				}
			}
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}

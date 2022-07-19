package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_13_bfs {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static int n, answer;
	public static int[][] arr;
	public static int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					answer++;
					bfs(i, j);
				}
			}
		}

		System.out.println(answer);
	}

	private static void bfs(int x, int y) {
		Deque<Point> deque = new ArrayDeque<>();
		deque.add(new Point(x, y));
		while (!deque.isEmpty()) {
			Point point = deque.remove();
			for (int i = 0; i < 8; i++) {
				int nx = move[i][0] + point.x;
				int ny = move[i][1] + point.y;
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
					arr[nx][ny] = 0;
					deque.add(new Point(nx, ny));
				}
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

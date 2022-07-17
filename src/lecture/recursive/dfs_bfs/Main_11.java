package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_11 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static int n = 8;
	public static int[][] miro;
	public static int[][] dis;
	public static int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {
		miro = new int[n][n];
		dis = new int[n][n];
		StringTokenizer st;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j < n; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 1);
		int answer = dis[n - 1][n - 1];
		if (answer == 0) {
			answer = -1;
		}
		System.out.println(answer);
	}

	private static void dfs(int x, int y) {
		Deque<Point> q = new ArrayDeque<>();
		q.add(new Point(x, y));
		miro[x][y] = 1;
		while (!q.isEmpty()) {
			Point point = q.remove();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + move[i][0];
				int ny = point.y + move[i][1];
				if (nx > 0 && nx < n && ny > 0 && ny < n && miro[nx][ny] == 0) {
					miro[nx][ny] = 1;
					q.add(new Point(nx, ny));
					dis[nx][ny] = dis[point.x][point.y] + 1;
				}
			}
		}

	}

	public static class Point {
		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

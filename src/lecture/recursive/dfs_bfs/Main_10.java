package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static int n = 8;
	public static int[][] miro;
	public static int answer;
	public static int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {
		miro = new int[n][n];
		StringTokenizer st;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j < n; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		miro[1][1] = 1;
		dfs(1, 1);
		System.out.println(answer);
	}

	private static void dfs(int x, int y) {
		if (x == n - 1 && y == n - 1) {
			answer++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + move[i][0];
			int ny = y + move[i][1];
			if (nx > 0 && nx < n && ny > 0 && ny < n && miro[nx][ny] == 0) {
				miro[nx][ny] = 1;
				dfs(nx, ny);
				miro[nx][ny] = 0;
			}
		}
	}

}

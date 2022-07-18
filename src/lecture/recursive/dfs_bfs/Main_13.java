package lecture.recursive.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13 {

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
					dfs(i, j);
				}
			}
		}

		System.out.println(answer);
	}

	private static void dfs(int x, int y) {
		arr[x][y] = 0;
		for (int i = 0; i < 8; i++) {
			int nx = x + move[i][0];
			int ny = y + move[i][1];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}

}

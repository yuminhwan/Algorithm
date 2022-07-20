package lecture.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_01_1 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		int[][] peoples = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			peoples[i][0] = Integer.parseInt(st.nextToken());
			peoples[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, peoples));
	}

	// 정답이지만 시간초과가 나야지 맞다. O(N^2)
	private static int solution(int n, int[][] peoples) {
		int answer = 0;

		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				if (peoples[i][0] < peoples[j][0] && peoples[i][1] < peoples[j][1]) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				answer++;
			}
		}

		return answer;
	}

}

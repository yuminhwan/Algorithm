package lecture.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_02 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		List<Meet> meets = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			meets.add(new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		System.out.println(solution(n, meets));
		bf.close();
	}

	private static int solution(int n, List<Meet> meets) {
		int count = 0;
		meets.sort(Comparator.comparingInt(Meet::getEnd)
			.thenComparingInt(Meet::getStart));

		int endTime = 0;
		for (Meet meet : meets) {
			if (meet.start >= endTime) {
				count++;
				endTime = meet.end;
			}
		}

		return count;
	}

	static class Meet {
		private final int start;
		private final int end;

		public Meet(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}
	}

}

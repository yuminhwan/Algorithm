package lecture.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_03 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		List<Time> times = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			times.add(new Time(Integer.parseInt(st.nextToken()), 's'));
			times.add(new Time(Integer.parseInt(st.nextToken()), 'e'));
		}
		System.out.println(solution(times));
		bf.close();
	}

	private static int solution(List<Time> times) {
		int answer = Integer.MIN_VALUE;
		times.sort(Comparator.comparingInt(Time::getTime)
			.thenComparing(Time::getState));

		int count = 0;
		for (Time time : times) {
			if (time.isStartTime()) {
				count++;
			} else {
				count--;
			}
			answer = Math.max(answer, count);
		}
		return answer;
	}

	static class Time {
		private final int time;
		private final char state;

		public Time(int time, char state) {
			this.time = time;
			this.state = state;
		}

		public boolean isStartTime() {
			return this.state == 's';
		}

		public int getTime() {
			return time;
		}

		public char getState() {
			return state;
		}
	}

}

package lecture.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_04 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(bf.readLine());
		List<Lecture> lectures = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			lectures.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		System.out.println(solution(lectures));
		bf.close();
	}

	private static int solution(List<Lecture> lectures) {
		int answer = 0;
		Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		lectures.sort(Comparator.comparingInt(Lecture::getDay).reversed());
		int max = lectures.get(0).getDay();

		int j = 0;
		for (int i = max; i >= 1; i--) {
			for (; j < n; j++) {
				if (lectures.get(j).day < i) {
					break;
				}
				queue.add(lectures.get(j).money);
			}
			answer += queue.remove();
		}
		return answer;
	}

	static class Lecture {
		private final int money;
		private final int day;

		public Lecture(int money, int day) {
			this.money = money;
			this.day = day;
		}

		public int getDay() {
			return day;
		}
	}

}

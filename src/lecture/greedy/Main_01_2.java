package lecture.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_01_2 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		List<People> peoples = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			peoples.add(new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		System.out.println(solution2(n, peoples));
	}

	private static int solution2(int n, List<People> peoples) {
		peoples.sort(Comparator.comparingInt(People::getHeight).reversed());
		int maxWeight = peoples.get(0).getWeight();
		int answer = 1;
		for (int i = 1; i < n; i++) {
			People people = peoples.get(i);
			if (maxWeight < people.weight) {
				maxWeight = people.weight;
				answer++;
			}
		}

		return answer;
	}

	private static int solution3(int n, List<People> peoples) {
		int cnt = 0;
		peoples.sort(Comparator.comparingInt(People::getHeight).reversed());
		int max = Integer.MIN_VALUE;
		for (People people : peoples) {
			if (people.weight > max) {
				max = people.weight;
				cnt++;
			}
		}
		return cnt;
	}

	static class People {
		int height;
		int weight;

		public People(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		public int getHeight() {
			return height;
		}

		public int getWeight() {
			return weight;
		}
	}

}

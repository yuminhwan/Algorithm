import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeSet<Problem> sortProblems = new TreeSet<>();
        int[] problems = new int[100010];

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            sortProblems.add(new Problem(number, level));
            problems[number] = level;
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("add")) {
                int number = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                sortProblems.add(new Problem(number, level));
                problems[number] = level;
            } else if (command.equals("solved")) {
                int number = Integer.parseInt(st.nextToken());
                sortProblems.remove(new Problem(number, problems[number]));
            } else {
                int check = Integer.parseInt(st.nextToken());
                if (check == 1) {
                    sb.append(sortProblems.last().number);
                } else {
                    sb.append(sortProblems.first().number);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static class Problem implements Comparable<Problem> {
        int number;
        int level;

        public Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level) {
                return this.number - o.number;
            }
            return this.level - o.level;
        }

    }

}

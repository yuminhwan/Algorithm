package lecture.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_04_2 {
    public static void main(String[] args) {
        Main_04_2 t = new Main_04_2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.next();
        }

        for (String answer : t.solution(n, str)) {
            System.out.println(answer);
        }
    }

    public List<String> solution(int n, String[] str) {
        List<String> answer = new ArrayList<>();
        for (String x : str) {
            String reverse = new StringBuilder(x).reverse().toString();
            answer.add(reverse);
        }
        return answer;
    }

    public List<String> solution2(int n, String[] str) {
        List<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = s.length - 1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }
}

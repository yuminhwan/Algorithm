package lecture.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(solution(n, str));
    }

    private static String solution(int n, String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String answer = "";

        for (char c : map.keySet()) {
            Integer cnt = map.get(c);
            if (cnt > max) {
                answer = String.valueOf(c);
                max = cnt;
            }
        }
        return answer;
    }

}

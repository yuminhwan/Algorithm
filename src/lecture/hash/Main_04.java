package lecture.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(solution(s, t));
    }

    private static int solution(String s, String t) {
        int answer = 0;
        Map<Character, Integer> answerMap = new HashMap<>();
        for (char x : t.toCharArray()) {
            answerMap.put(x, answerMap.getOrDefault(x, 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>();
        int len = t.length();
        for (int i = 0; i < len - 1; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int start = 0;
        for (int i = len - 1; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            if (map.equals(answerMap)) {
                answer++;
            }

            if (map.get(s.charAt(start)) == 1) {
                map.remove(s.charAt(start));
            } else {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
            }
            start++;
        }
        return answer;
    }

    private static int solution2(String a, String b) {
        int answer = 0;
        Map<Character, Integer> am = new HashMap<>();
        Map<Character, Integer> bm = new HashMap<>();

        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        int len = b.length() - 1;
        for (int i = 0; i < len; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        int start = 0;
        for (int end = len; end < a.length(); end++) {
            am.put(a.charAt(end), am.getOrDefault(a.charAt(end), 0) + 1);

            if (am.equals(bm)) {
                answer++;
            }

            am.put(a.charAt(start), am.get(a.charAt(start)) - 1);
            if (am.get(a.charAt(start)) == 0) {
                am.remove(a.charAt(start));
            }
            start++;
        }
        return answer;
    }
}

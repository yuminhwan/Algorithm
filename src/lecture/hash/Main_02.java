package lecture.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();
        System.out.println(solution(first, second));
    }

    private static String solution(String first, String second) {
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();

        Arrays.sort(firstChars);
        Arrays.sort(secondChars);

        if (String.valueOf(firstChars).equals(String.valueOf(secondChars))) {
            return "YES";
        }
        return "NO";
    }

    private static String solution2(String first, String second) {
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();

        Map<Character, Integer> firstMap = new HashMap<>();
        Map<Character, Integer> secondMap = new HashMap<>();

        for (char c : firstChars) {
            firstMap.put(c, firstMap.getOrDefault(c, 0) + 1);
        }

        for (char c : secondChars) {
            secondMap.put(c, secondMap.getOrDefault(c, 0) + 1);
        }

        if (firstMap.equals(secondMap)) {
            return "YES";
        }
        return "NO";
    }

    private static String solution3(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return "NO";
            }
            map.put(c, map.get(c) - 1);
            // map.computeIfPresent(c, (k, v) -> v - 1);
        }
        return "YES";
    }
}

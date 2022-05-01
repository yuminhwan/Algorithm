package lecture.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_06 {
    public static void main(String[] args) {
        Main_06 t = new Main_06();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));
    }

    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.add(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String solution2(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}

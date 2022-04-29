package lecture.string;

import java.util.Scanner;

public class Main_02 {

    public static void main(String[] args) {
        Main_02 t = new Main_02();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(t.solution(input));
    }

    private String solution(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (97 <= c && c <= 122) {
                sb.append((char)(c - 32));
            } else {
                sb.append((char)(c + 32));
            }
        }
        return sb.toString();
    }
}

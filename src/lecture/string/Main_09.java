package lecture.string;

import java.util.Scanner;

public class Main_09 {
    public static void main(String[] args) {
        Main_09 t = new Main_09();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));
    }

    public int solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public int solution2(String str) {
        str = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(str);
    }

    public int solution3(String str) {
        int answer = 0;
        for (char c : str.toCharArray()) {
            if (48 <= c && c <= 57) {
                answer = answer * 10 + (c - 48);
            }
        }
        return answer;
    }
}

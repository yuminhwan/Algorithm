package lecture.string;

import java.util.Scanner;

public class Main_07 {
    public static void main(String[] args) {
        Main_07 t = new Main_07();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(t.solution(str));
    }

    public String solution(String str) {
        String input = str.toLowerCase();
        String reverse = new StringBuilder(input).reverse().toString();
        if (input.equals(reverse)) {
            return "YES";
        }
        return "NO";
    }

    public String solution2(String str) {
        char[] c = str.toLowerCase().toCharArray();
        int lt = 0;
        int rt = c.length - 1;
        while (lt < rt) {
            if (c[lt] != c[rt]) {
                return "NO";
            }
            lt++;
            rt--;
        }

        return "YES";
    }

    public String solution3(String str) {
        str = str.toLowerCase();
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return "NO";
            }
        }
        return "YES";
    }

    public String solution4(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(reverse)) {
            return "YES";
        }
        return "NO";
    }
}

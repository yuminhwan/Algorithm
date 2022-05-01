package lecture.string;

import java.util.Scanner;

public class Main_05 {
    public static void main(String[] args) {
        Main_05 t = new Main_05();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));
    }

    public String solution(String str) {
        char[] c = str.toCharArray();
        int lt = 0;
        int rt = c.length - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(c[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(c[rt])) {
                rt--;
            } else {
                char temp = c[lt];
                c[lt] = c[rt];
                c[rt] = temp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(c);
    }
}

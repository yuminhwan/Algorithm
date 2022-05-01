package lecture.string;

import java.util.Scanner;

public class Main_04_1 {
    public static void main(String[] args) {
        Main_04_1 t = new Main_04_1();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            System.out.println(t.solution(str));
        }
    }

    public String solution(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}

package lecture.string;

import java.util.Scanner;

public class Main_08 {
    public static void main(String[] args) {
        Main_08 t = new Main_08();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(t.solution(str));
    }

    public String solution(String str) {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        String reverse = new StringBuilder(str).reverse().toString();
        if (str.equals(reverse)) {
            return "YES";
        }
        return "NO";
    }
}

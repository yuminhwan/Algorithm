package lecture.string;

import java.util.Scanner;

public class Main_01 {

    public static void main(String[] args) {
        Main_01 t = new Main_01();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char find = scanner.next().charAt(0);
        System.out.println(t.solution(input, find));
    }

    public int solution(String str, char c) {
        int answer = 0;
        str = str.toLowerCase();
        c = Character.toLowerCase(c);

        for (char x : str.toCharArray()) {
            if (x == c) {
                answer++;
            }
        }
        return answer;
    }
}

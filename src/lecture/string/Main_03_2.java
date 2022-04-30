package lecture.string;

import java.util.Scanner;

public class Main_03_2 {
    public static void main(String[] args) {
        Main_03_2 t = new Main_03_2();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(t.soultion(str));
    }

    public String soultion(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        String[] arr = str.split(" ");
        for (String s : arr) {
            int len = s.length();
            if (len > max) {
                max = len;
                answer = s;
            }
        }
        return answer;
    }
}

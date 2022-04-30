package lecture.string;

import java.util.Scanner;

public class Main_03_3 {
    public static void main(String[] args) {
        Main_03_3 t = new Main_03_3();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(t.soultion(str));
    }

    public String soultion(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int pos;

        while ((pos = str.indexOf(' ')) != -1) {
            String s = str.substring(0, pos);
            int len = s.length();
            if (len > max) {
                max = len;
                answer = s;
            }
            str = str.substring(pos + 1);
        }

        if (str.length() > max) {
            answer = str;
        }

        return answer;
    }
}

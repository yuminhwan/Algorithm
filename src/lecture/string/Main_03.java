package lecture.string;

import java.util.Arrays;
import java.util.Scanner;

public class Main_03 {
    public static void main(String[] args) {
        Main_03 t = new Main_03();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(t.soultion(str));
    }

    public String soultion(String str) {
        String[] arr = str.split(" ");
        Arrays.sort(arr, (o1, o2) -> o2.length() - o1.length());
        return arr[0];
    }

    public String soultion2(String str) {
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

    public String soultion3(String str) {
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

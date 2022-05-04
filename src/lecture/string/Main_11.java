package lecture.string;

import java.util.Scanner;

public class Main_11 {
    public static void main(String[] args) {
        Main_11 t = new Main_11();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));
    }

    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int next = i + 1;
            int cnt = 1;
            while ((next < str.length()) && (str.charAt(i) == str.charAt(next))) {
                next++;
                cnt++;
            }
            sb.append(str.charAt(i));
            if (cnt != 1) {
                sb.append(cnt);
                i += (cnt - 1);
            }
        }
        return sb.toString();
    }

    public String solution2(String str) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < str.length(); i++) {
            if ((i != str.length() - 1) && (str.charAt(i) == str.charAt(i + 1))) {
                cnt++;
            } else {
                sb.append(str.charAt(i));
                if (cnt != 1) {
                    sb.append(cnt);
                }
                cnt = 1;
            }
        }
        return sb.toString();
    }

    public String solution3(String str) {
        StringBuilder answer = new StringBuilder();
        str = str + " ";
        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                answer.append(str.charAt(i));
                if (cnt > 1) {
                    answer.append(cnt);
                }
                cnt = 1;
            }
        }
        return answer.toString();
    }

}

package lecture.string;

import java.util.Scanner;

public class Main_12 {
    public static void main(String[] args) {
        Main_12 t = new Main_12();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(t.solution(n, str));
    }

    public String solution(int n, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = i * 7;
            String s = str.substring(index, index + 7);
            s = s.replace("#", "1").replace("*", "0");
            sb.append((char)Integer.parseInt(s, 2));
        }
        return sb.toString();
    }

    public String solution2(int n, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = str.substring(0, 7).replace('#', '1').replace('*', '0');
            sb.append((char)Integer.parseInt(s, 2));
            str = str.substring(7);
        }
        return sb.toString();
    }

    public String solution3(int n, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = str.substring(0, 7);
            StringBuilder replace = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '#') {
                    replace.append("1");
                } else {
                    replace.append("0");
                }
            }
            sb.append((char)Integer.parseInt(replace.toString(), 2));
            str = str.substring(7);
        }
        return sb.toString();
    }

}

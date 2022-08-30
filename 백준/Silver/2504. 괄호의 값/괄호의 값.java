import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> s = new Stack<>();
        String str = br.readLine();
        int ans = 0;
        int cnt = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                cnt *= 2;
                s.push(c);
            } else if (c == '[') {
                cnt *= 3;
                s.push(c);
            } else {
                if (c == ')') {
                    if (s.isEmpty() || s.peek() != '(') {
                        ans = 0;
                        break;
                    }

                    if (str.charAt(i - 1) == '(') {
                        ans += cnt;
                    }

                    s.pop();
                    cnt /= 2;
                } else if (c == ']') {
                    if (s.isEmpty() || s.peek() != '[') {
                        ans = 0;
                        break;
                    }

                    if (str.charAt(i - 1) == '[') {
                        ans += cnt;
                    }

                    s.pop();
                    cnt /= 3;
                } else {
                    ans = 0;
                    break;
                }
            }
        }

        if (!s.isEmpty()) {
            ans = 0;
        }
        System.out.println(ans);

    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        System.out.println(main.solution(N, arr));
    }

    private int solution(int n, String[] arr) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String str = arr[i];
            int len = str.length();
            if (len % 2 != 0) {
                continue;
            }

            Stack<Character> stack = new Stack<>();
            stack.push(str.charAt(0));
            for (int j = 1; j < len; j++) {
                char c = str.charAt(j);
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}

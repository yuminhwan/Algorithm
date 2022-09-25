import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine();
        }
        for (String s : main.solution(N, commands)) {
            System.out.println(s);
        }
    }

    private String[] solution(int n, String[] commands) {
        List<String> answer = new ArrayList<>();
        for (String command : commands) {
            List<Character> password = new LinkedList<>();
            int top = 0;
            for (char cmd : command.toCharArray()) {
                if (cmd == '<') {
                    if (top != 0) {
                        top--;
                    }
                } else if (cmd == '>') {
                    if (top != password.size()) {
                        top++;
                    }
                } else if (cmd == '-') {
                    if (top != 0) {
                        password.remove(--top);
                    }
                } else {
                    password.add(top++, cmd);
                }
            }
            String str = password.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
            answer.add(str);
        }
        return answer.toArray(String[]::new);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] commands = new String[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            commands[i][0] = st.nextToken();
            commands[i][1] = st.nextToken();
        }
        for (String x : main.solution(N, commands)) {
            System.out.println(x);
        }
    }

    private List<String> solution(int n, String[][] commands) {
        Set<String> peoples = new HashSet<>();
        for (String[] command : commands) {
            String name = command[0];
            String record = command[1];

            if ("enter".equals(record)) {
                peoples.add(name);
            } else {
                peoples.remove(name);
            }
        }
        return peoples.stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
    }
}

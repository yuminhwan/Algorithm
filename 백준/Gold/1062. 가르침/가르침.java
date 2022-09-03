import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.next();
        }
        System.out.println(main.solution(N, K, arr));
    }

    static int N, K;
    static String[] words;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    private int solution(int N, int K, String[] word) {
        if (K < 5) {
            return 0;
        }

        if (K == 26) {
            return N;
        }

        visited = new boolean[26];
        for (char c : "aticn".toCharArray()) {
            visited[c - 'a'] = true;
        }

        Main.words = Arrays.stream(word)
            .map(i -> i.substring(4, i.length() - 4))
            .toArray(String[]::new);

        dfs(0, 0);
        return max;
    }

    private void dfs(int alpha, int level) {
        if (level == K - 5) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                String word = words[i];
                if (isReadable(word)) {
                    cnt++;
                }
            }
            max = Math.max(cnt, max);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, level + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isReadable(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!visited[word.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}

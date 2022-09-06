import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        System.out.println(main.solution(N));
    }

    private int solution(long num) {
        long sum = 0;
        int count = 0;
        for (int i = 1; ; i++) {
            if (sum > num) {
                break;
            }
            sum += i;
            count++;
        }
        return count - 1;
    }
}

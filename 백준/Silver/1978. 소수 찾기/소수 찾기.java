import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ans = 0;

        while (st.hasMoreTokens()) {

            // 소수인경우 true, 아닌경우 false
            boolean isPrime = true;

            int num = Integer.parseInt(st.nextToken());

            if (num == 1) {
                continue;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}

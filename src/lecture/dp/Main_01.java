package lecture.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_01 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dy;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());
        dy = new int[n + 1];
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        return dy[n];
    }

    public static int solution2(int n) {
        if (dy[n] > 0) {
            return dy[n];
        }

        if (n <= 2) {
            return dy[n] = n;
        }
        return dy[n] = solution2(n - 1) + solution2(n - 2);
    }
}


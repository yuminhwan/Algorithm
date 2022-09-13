import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Long> arr;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        System.out.println(main.solution(N));
    }

    private long solution(int n) {
        if (n <= 10) {
            return n;
        }

        if (n > 1022) {
            return -1;
        }

        for (int i = 0; i < 10; i++) {
            findNum(i, 1);
        }
        Collections.sort(arr);
        return arr.get(n);
    }

    // num이 1이면 i가 0일때 까지만 -> 1뒤에 올 수 있는 감소하는 수 1, 10
    // num이 2면 2, 20, 21, 210
    // num이 3이면 3,30,31,310...
    private void findNum(long num, int depth) {
        if (depth > 10) {
            return;
        }
        arr.add(num);
        for (int i = 0; i < num % 10; i++) {
            findNum((num * 10) + i, depth + 1);
        }
    }
}

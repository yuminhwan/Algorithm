import java.util.Scanner;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] arr, op;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = scanner.nextInt();
        }
        main.solution(1, arr[0]);
        System.out.println(max + "\n" + min);
    }

    public void solution(int level, int total) {
        if (level == n) {
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] != 0) {
                op[i]--;
                int value = calculate(i, total, arr[level]);
                solution(level + 1, value);
                op[i]++;
            }
        }
    }

    private int calculate(int index, int total, int value) {
        switch (index) {
            case 0:
                return total + value;
            case 1:
                return total - value;
            case 2:
                return total * value;
            case 3:
                return total / value;
        }
        return 0;
    }
}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int[] blocks = new int[w];
        for (int i = 0; i < w; i++) {
            blocks[i] = scanner.nextInt();
        }
        System.out.println(main.solution(h, w, blocks));
    }

    private int solution(int h, int w, int[] blocks) {
        int answer = 0;

        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, blocks[j]);
            }

            for (int j = i + 1; j < w; j++) {
                right = Math.max(right, blocks[j]);
            }

            if (blocks[i] < left && blocks[i] < right) {
                answer += Math.min(left, right) - blocks[i];
            }
        }
        return answer;
    }
}

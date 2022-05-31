package lecture.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Main_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        int m = scanner.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt();
        }
        System.out.println(solution(board, moves));
    }

    private static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                int next = board[j][move - 1];
                if (next != 0) {
                    if (bucket.isEmpty() || bucket.peek() != next) {
                        bucket.push(next);
                    } else {
                        bucket.pop();
                        answer++;
                    }
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer * 2;
    }

    private static int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                int next = board[j][move - 1];
                if (next != 0) {
                    board[j][move - 1] = 0;
                    if (!bucket.isEmpty() && bucket.peek() == next) {
                        bucket.pop();
                        answer += 2;
                    } else {
                        bucket.push(next);
                    }
                    break;
                }
            }
        }
        return answer;
    }

}

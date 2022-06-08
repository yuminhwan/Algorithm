package lecture.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        int[] temp = arr.clone();
        Arrays.sort(temp);

        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

}

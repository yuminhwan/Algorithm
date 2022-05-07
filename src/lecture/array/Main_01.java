package lecture.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_01 {
    public static void main(String[] args) {
        Main_01 t = new Main_01();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(t.solution(arr));
    }

    public String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.toString();
    }

    public List<Integer> solution2(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}

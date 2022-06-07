package lecture.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, arr));
    }

    private static String solution(int n, int[] arr) {
        Arrays.asList(arr);
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (!set.add(x)) {
                return "D";
            }
        }
        return "U";
    }

    private static String solution2(int n, int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }
        return "U";
    }

}

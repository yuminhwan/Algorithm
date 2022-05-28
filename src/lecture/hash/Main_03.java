package lecture.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int x : solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> solution(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.size());

        for (int i = k; i < n; i++) {
            int removeNum = arr[i - k];
            if (map.get(removeNum) == 1) {
                map.remove(removeNum);
            } else {
                map.put(removeNum, map.get(removeNum) - 1);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            answer.add(map.size());
        }
        return answer;
    }

    private static List<Integer> solution2(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int start = 0;
        for (int end = k - 1; end < n; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            answer.add(map.size());
            map.put(arr[start], map.get(arr[start]) - 1);
            if (map.get(arr[start]) == 0) {
                map.remove(arr[start]);
            }
            start++;
        }
        return answer;
    }
}

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

    private static String solution3(int n, int[] arr) {
        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }
        return "U";
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {

        int mid = (left + right) / 2;
        swap(arr, left, mid);

        int pivot = arr[left];
        int lo = left;
        int hi = right;

        while (lo < hi) {
            while (pivot < arr[hi] && lo < hi) {
                hi--;
            }

            while (pivot >= arr[lo] && lo < hi) {
                lo++;
            }

            swap(arr, lo, hi);
        }

        swap(arr, left, lo);
        return lo;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

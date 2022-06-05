package lecture.sort;

import java.util.Scanner;

public class InsertionSort {
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

    private static int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int prev = i - 1;
            while ((prev >= 0) && (arr[prev] > temp)) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = temp;
        }
        return arr;
    }

    private static int[] solution2(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int prev;
            for (prev = i - 1; prev >= 0; prev--) {
                if (arr[prev] > temp) {
                    arr[prev + 1] = arr[prev];
                } else {
                    break;
                }
            }
            arr[prev + 1] = temp;
        }
        return arr;
    }

}

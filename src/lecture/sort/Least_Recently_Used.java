package lecture.sort;

import java.util.Scanner;

public class Least_Recently_Used {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int x : solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(int size, int n, int[] work) {
        int[] cache = new int[size];

        for (int x : work) {
            int findIndex = indexOf(cache, x);
            if (findIndex == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = findIndex; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }

    private static int indexOf(int[] cache, int x) {
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == x) {
                return i;
            }
        }
        return -1;
    }

    private static int[] solution2(int size, int n, int[] arr) {
        int[] cache = new int[size];

        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) {
                if (x == cache[i]) {
                    pos = i;
                }
            }

            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }

}

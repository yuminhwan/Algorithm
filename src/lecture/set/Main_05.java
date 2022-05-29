package lecture.set;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }
        System.out.println(solution(n, k, cards));
    }

    private static int solution(int n, int k, int[] cards) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int z = j + 1; z < n; z++) {
                    set.add(cards[i] + cards[j] + cards[z]);
                }
            }
        }

        int cnt = 0;
        for (int x : set) {
            cnt++;
            if (cnt == k) {
                return x;
            }
        }

        return -1;
    }
}

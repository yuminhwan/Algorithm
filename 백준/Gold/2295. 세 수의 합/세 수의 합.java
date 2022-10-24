import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(main.solution(N, arr));
    }

    private int solution(int n, int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int target = arr[i] - arr[j];
                if (set.contains(target)) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    private boolean isInsideTwoSum(List<Integer> twoSum, int target) {
        int st = 0;
        int en = twoSum.size() - 1;

        while (st <= en) {
            int mid = (st + en) / 2;
            int value = twoSum.get(mid);
            if (value == target) {
                return true;
            } else if (value > target) {
                en = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return false;
    }
}

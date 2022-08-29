import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        int spyA = 0;
        int spyB = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum - (arr[i] + arr[j]) == 100) {
                    spyA = arr[i];
                    spyB = arr[j];
                }
            }
        }

        for (int val : arr) {
            if (val == spyA || val == spyB) {
                continue;
            }
            System.out.println(val);
        }

    }
}


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[1001];

        int count = 1;

        for (int i = 1; i < 1001; i++) {
            for (int j = 0; j < i; j++) {
                if (count == 1001) {
                    break;
                }
                arr[count] = i;
                count++;
            }
        }

        int sum = 0;
        for (int i = a; i < b + 1; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}


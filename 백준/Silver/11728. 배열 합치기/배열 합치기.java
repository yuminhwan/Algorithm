import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int x : main.solution(N, M, A, B)) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    private int[] solution(int n, int m, int[] a, int[] b) {
        int totalLength = a.length + b.length;
        int[] result = new int[totalLength];

        int aIdx = 0;
        int bIdx = 0;

        for (int i = 0; i < totalLength; i++) {
            if (bIdx == m) {
                result[i] = a[aIdx++];
            } else if (aIdx == n) {
                result[i] = b[bIdx++];
            } else if (a[aIdx] <= b[bIdx]) {
                result[i] = a[aIdx++];
            } else {
                result[i] = b[bIdx++];
            }
        }
        return result;
    }
}

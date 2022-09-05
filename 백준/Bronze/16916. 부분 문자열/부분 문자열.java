import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        System.out.println(solution(S, P));
    }

    private static int solution(String S, String P) {
        int[] f = getFailure(P);
        int j = 0;

        for (int i = 0; i < S.length(); i++) {
            while (j > 0 && S.charAt(i) != P.charAt(j)) {
                j = f[j - 1];
            }
            if (S.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    return 1;
                }
                j++;
            }
        }
        return 0;
    }

    private static int[] getFailure(String str) {
        int len = str.length();
        int[] f = new int[len];
        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = f[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                f[i] = ++j;
            }
        }
        return f;
    }
}

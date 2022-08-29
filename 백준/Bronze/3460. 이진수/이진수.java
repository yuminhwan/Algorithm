import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (n != 1) {
                sb.append(n % 2);
                n /= 2;
            }

            sb.append(n);
            String ans = sb.toString();

            for (int i = 0; i < ans.length(); i++) {
                if (ans.charAt(i) == '1') {
                    System.out.print(i + " ");
                }
            }
        }
    }
}


package lecture.recursive;

import java.util.Scanner;

public class Main_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(dfs(n));
    }

    private static int dfs(int n) {
        if (n == 1) {
            return 1;
        }
        return n * dfs(n - 1);
    }

}

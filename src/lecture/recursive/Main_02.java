package lecture.recursive;

import java.util.Scanner;

public class Main_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dfs(n);
    }

    private static void dfs(int n) {
        if (n == 0) {
            return;
        }

        dfs(n / 2);
        System.out.print(n % 2);
    }

}

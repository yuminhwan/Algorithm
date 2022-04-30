package lecture.string;

import java.util.Arrays;
import java.util.Scanner;

public class Main_03_1 {
    public static void main(String[] args) {
        Main_03_1 t = new Main_03_1();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(t.soultion(str));
    }

    public String soultion(String str) {
        String[] arr = str.split(" ");
        Arrays.sort(arr, (o1, o2) -> o2.length() - o1.length());
        return arr[0];
    }
}

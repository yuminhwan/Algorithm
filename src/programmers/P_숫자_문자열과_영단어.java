package programmers;

public class P_숫자_문자열과_영단어 {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.solution("one4seveneight"));
    }

    public int solution(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replace(words[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}

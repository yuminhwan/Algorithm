import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] order = new int[K];
        for (int i = 0; i < K; i++) {
            order[i] = scanner.nextInt();
        }
        System.out.println(main.solution(N, K, order));
    }

    private int solution(int N, int K, int[] order) {
        boolean[] used = new boolean[101];
        int answer = 0;
        int put = 0;

        for (int i = 0; i < K; i++) {
            int store = order[i];

            if (!used[store]) {                 // 현재 물건의 콘센트가 꽂혀 있지 않을 경우
                if (put < N) {                 // 멀티탭에 꽂을 공간이 있을 경우
                    used[store] = true;
                    put++;
                } else {                        // 멀티탭에 꽂을 공간이 없을 경우
                    List<Integer> laterUsed = new ArrayList<>();
                    for (int j = i; j < K; j++) {  // 현재 꽂혀 있는 물건이 나중에도 멀티탭을 사용하는 지 확인
                        int next = order[j];       // 사용한다면 laterUsed에 저장
                        if (used[next] && !laterUsed.contains(next)) {
                            laterUsed.add(next);
                        }
                    }

                    if (laterUsed.size() == N) {   // 현재 꽂혀 있는 물건들 모두가 나중에도 멀티탭을 사용할 때
                        int remove = laterUsed.get(laterUsed.size() - 1);     // 그 중 제일 나중에 멀티탭을 사용하는 물건 콘센트 제거
                        used[remove] = false;
                    } else {                       // 나중에도 사용할 물건이 멀티탭의 콘센트 수보다 작다면 즉, 나중에 사용안하는 물건이 존재
                        for (int j = 1; j <= K; j++) {
                            if (used[j] && !laterUsed.contains(j)) {    // 나중에 사용안하는 물건을 찾아 제거
                                used[j] = false;
                                break;
                            }
                        }
                    }
                    used[store] = true;
                    answer++;
                }
            }
        }

        return answer;
    }
}

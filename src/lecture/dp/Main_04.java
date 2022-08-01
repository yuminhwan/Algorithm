package lecture.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_04 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());
        Block[] blocks = new Block[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            blocks[i] = new Block(dx, dy, weight);
        }
        System.out.println(solution(n, blocks));
    }

    private static int solution(int n, Block[] blocks) {
        int[] dy = new int[n];
        Arrays.sort(blocks, Comparator.comparingInt(Block::getDx).reversed());
        dy[0] = blocks[0].dy;
        int answer = dy[0];
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (blocks[j].weight > blocks[i].weight && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + blocks[i].dy;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    static class Block {
        int dx;
        int dy;
        int weight;

        public Block(int dx, int dy, int weight) {
            this.dx = dx;
            this.dy = dy;
            this.weight = weight;
        }

        public int getDx() {
            return dx;
        }
    }
}

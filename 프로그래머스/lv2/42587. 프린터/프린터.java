import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            queue.add(priority);
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    if (i == location) {
                        return answer + 1;
                    }
                    queue.remove();
                    answer++;
                }
            }
        }

        return answer;
    }
}
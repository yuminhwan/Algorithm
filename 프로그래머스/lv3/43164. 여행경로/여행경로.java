import java.util.*;

class Solution {
    
    static List<String> answer = new ArrayList<>();
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", 0, tickets);

        answer.sort(Comparator.naturalOrder());
        return answer.get(0).split(" ");
    }

    private void dfs(String start, String result, int level, String[][] tickets) {
        if (level == tickets.length) {
            answer.add(result);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                String next = tickets[i][1];
                dfs(next, result + " " + next, level + 1, tickets);
                visited[i] = false;
            }
        }
    }
    

}
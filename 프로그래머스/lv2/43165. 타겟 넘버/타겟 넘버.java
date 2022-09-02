class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int level, int result) {
        if (level == numbers.length) {
            if(result == target) {
                answer++;   
                return;
            }
        } else {
         dfs(numbers, target, level + 1, result + numbers[level]);
         dfs(numbers, target, level + 1, result - numbers[level]);   
        }
    }
}
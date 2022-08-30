class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length; 
        
        for(int i = 0; i<len; i++) {
            for(int j = i + 1; j<len; j++) {
                for(int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)){
                       answer++; 
                    }
                }
            }
        }
        return answer;
    }
    
    public boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }
        
        for(int i = 2; i*i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>(); 
        
        Arrays.sort(nums);
        int len = nums.length; 
    
        
        for(int i = 0; i<len; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue; 
            }
            
            int left = i+1;
            int right = len - 1; 
            
            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    answer.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    while(nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                    while(nums[right] == nums[right + 1] && left < right) {
                        right--;
                    }
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return answer;
    }
}
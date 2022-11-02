import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int previous = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num == previous) {
                return true;
            }
            previous = num;
        }
        return false;
    }
}
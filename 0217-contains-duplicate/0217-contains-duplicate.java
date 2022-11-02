import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> nonDuplicateNums = new HashSet<>();
        
        for(int num : nums) {
            if(!nonDuplicateNums.add(num)) {
                return true;
            }
        }
        return false;
    }
}
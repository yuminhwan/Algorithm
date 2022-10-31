import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1. 인덱스 저장용 Map 
        Map<Integer, Integer> mappingIndex = new HashMap<>();
        
        // 2. nums1, nums2 포인터 , index 변수
        int index = 0;
        int oneIndex = 0;
        int twoIndex = 0;
        
        // 3.  포인터1 < m && 포인터2 < n 반복 
        // 3-1. nums1[포인터1] <= nums2[포인터2] -> map에 저장 및 포인터1++
        // 3-2. map 저장 및 포인터2++ 
        while(oneIndex < m && twoIndex < n) { // 2 < 3 0 < 3  1
            if(nums1[oneIndex] <= nums2[twoIndex]) {      
                mappingIndex.put(index, nums1[oneIndex]);  
                oneIndex++;
            } else {
                mappingIndex.put(index, nums2[twoIndex]);
                twoIndex++;
            }
            index++; // 0,1 1,2 
        }
        
        // 4. num2값이 아직 다 안들어갔따면 포인터1 == m -> 남은 nums2값 모두 map에 
        if(twoIndex != n) {
            for(int i = twoIndex; i<n; i++) {
                mappingIndex.put(index, nums2[i]);
                index++;
            }
        } 
        
        // 5. 포인터2 == m -> 남은 nums1값 모두 map에 
        if(oneIndex != m) {
            for(int i = oneIndex; i<m; i++) {
                mappingIndex.put(index, nums1[i]);
                index++;
            }
        } 
        
        for(int i = 0; i<m+n; i++) {
            nums1[i] = mappingIndex.get(i);
        }
    }
}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int oneTail = m-1;
        int twoTail = n-1; 
        int tail = m+n-1;
        
        while(oneTail >= 0 && twoTail >= 0) {
            if(nums1[oneTail] >= nums2[twoTail]) {
                nums1[tail] = nums1[oneTail]; 
                oneTail--;
            } else {
                nums1[tail] = nums2[twoTail]; 
                twoTail--;
            }
            tail--;
        }
        
        while(twoTail >= 0) {
            nums1[tail] = nums2[twoTail];
            tail--;
            twoTail--;
        }
        
    }
}
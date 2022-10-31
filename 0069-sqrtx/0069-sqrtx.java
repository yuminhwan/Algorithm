/** 
* privious <= x루트 
* privious^2 <= x 
* 시간복잡도 : privious -> 0 ~ x루트까지 값 중 이분탐색 -> O(log(x루트))
* 공간복잡도 : O(1)
*/
class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        
        int left = 1;
        int right = x;
        
        while(left <= right) {
            int mid = left + (right - left) / 2; 
            
            if(mid <= x/mid && (mid + 1) > x / (mid + 1)) {
                return mid; 
            } else if(mid <= x/mid){
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
            
        }
        return left;
    }
}
/**
* 시간복잡도 : O(N)
* 공간복잡도 : O(1)
*/
class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return n;
        }
        
        int oneStep = 1;
        int twoStep = 2;
        for(int i = 3; i<=n; i++) {
            int tmp = twoStep; 
            twoStep += oneStep; 
            oneStep = tmp;
        }
        return twoStep;
    }
}
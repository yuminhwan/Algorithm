/** 
* privious <= x루트 
* privious^2 <= x 
* 시간복잡도 : privious -> 0 ~ x루트 까지 O(x루트) 
* 공간복잡도 : O(1)
*/
class Solution {
    public int mySqrt(int x) {
        long privious = 0;   
        while((privious * privious) <= x) { 
            privious++;
        }
        return (int)privious - 1;
    }
}
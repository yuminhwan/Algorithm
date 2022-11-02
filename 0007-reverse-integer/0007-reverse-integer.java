class Solution {
    public int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            int newResult = answer * 10 + lastDigit;
            if ((newResult - lastDigit) / 10 != answer) {
                return 0;
            }
            answer = newResult;
            x /= 10;
        }
        return answer;
    }
}
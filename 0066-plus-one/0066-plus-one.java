class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        // 배열의 끝부터 순환하며 9인지 확인한다.
        // 9라면 0을 대입해주고 계속 순환한다.
        // 9가 아니라면 1을 더한 뒤 return한다.
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // 9 -> 10 과 같이 배열의 길이를 넘어간다면 배열의 길이 + 1인 배열을 생성 후 제일 앞쪽에 1을 넣는다.
        return getUpperDigits(len);
    }

    private int[] getUpperDigits(int len) {
        int[] upperDigits = new int[len + 1];
        upperDigits[0] = 1;
        return upperDigits;
    }
}
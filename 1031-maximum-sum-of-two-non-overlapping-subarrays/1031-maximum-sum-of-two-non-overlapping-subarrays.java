class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max_sum1 = 0, max_sum2 = 0;
        int ans1 = 0, sum1 = 0, sum2 = 0;
        int ans2 = 0, max_ans = 0;

        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];

            if (i - secondLen >= 0) {
                sum2 -= nums[i - secondLen];
                sum1 += nums[i - secondLen];
            }

            if (i - secondLen - firstLen >= 0) {
                sum1 -= nums[i - secondLen - firstLen];
            }

            if (i >= firstLen + secondLen - 1) {
                max_sum1 = Math.max(max_sum1, sum1);
                ans1 = Math.max(ans1, max_sum1 + sum2);
            }
        }

        sum1 = 0;
        sum2 = 0;

        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];

            if (i - firstLen >= 0) {
                sum1 -= nums[i - firstLen];
                sum2 += nums[i - firstLen];
            }

            if (i - firstLen - secondLen >= 0) {
                sum2 -= nums[i - firstLen - secondLen];
            }

            if (i >= firstLen + secondLen - 1) {
                max_sum2 = Math.max(max_sum2, sum2);
                ans2 = Math.max(ans2, max_sum2 + sum1);
            }
        }

        max_ans = Math.max(ans1, ans2);
        return max_ans;
    }
}
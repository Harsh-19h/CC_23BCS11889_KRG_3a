import java.util.Arrays;

public class LIS {
    // O(n^2) DP for length of Longest Increasing Subsequence
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS length: " + lengthOfLIS(nums1)); // Expected: 4 (2,3,7,101 or similar)
        
        int[] nums2 = {0,1,0,3,2,3};
        System.out.println("LIS length: " + lengthOfLIS(nums2)); // Expected: 4
    }
}

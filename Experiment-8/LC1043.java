package Exp 8 Conduct;

public class LC1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int []dp= new int[n+1];
        for(int i=n-1;i>=0;i--){
            int maxi=0;
            int len=0;
            int ans=0;
            for(int idx=i;idx<Math.min(n,i+k);idx++){
                maxi=Math.max(maxi,arr[idx]);
                len++;
                int sum =maxi*len + dp[idx+1];
                ans=Math.max(ans,sum);
            }
            dp[i]=ans;

        }
        return dp[0];
    }
}

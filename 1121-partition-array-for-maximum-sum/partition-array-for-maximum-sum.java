class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[501];
        Arrays.fill(dp, -1);
        return solve(0, arr, k, dp);
    }

    public int solve(int i, int [] arr, int k, int[] dp){
        int result = 0;
        int curr_max = -1;
        int n = arr.length;
        if(dp[i] != -1) return dp[i];
        for(int j = i; j<n && (j-i+1) <=k ; j++ ){
            curr_max = Math.max(curr_max, arr[j]);
            result = Math.max(result, ((j-i+1)*curr_max + solve(j+1, arr, k, dp)));
        } 
        return dp[i] = result;
    }
}
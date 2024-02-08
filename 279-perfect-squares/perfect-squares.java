class Solution {
    public int numSquares(int n) {
        // Recursive code 
        // if (n == 0) return 0;
        // int minNum = Integer.MAX_VALUE;
        // for(int i=1; i*i <= n; i++){
        //     int temp = 1 + numSquares(n- i*i);
        //     minNum = Math.min(minNum , temp);
        // }
        // return minNum;


        // memoizing it 
        // if (n == 0) return 0;
        // int [] dp = new int[1001];
        // Arrays.fill(dp, -1);
        // if(dp[n] != -1) return dp[n];
        // int minNum = Integer.MAX_VALUE;
        // for(int i=1; i*i <= n; i++){
        //     int temp = 1 + numSquares(n- i*i);
        //     minNum = Math.min(minNum , temp);
        // }
        // return dp[n] = minNum;


        // Bottom Up
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }
        return dp[n];
    }
}
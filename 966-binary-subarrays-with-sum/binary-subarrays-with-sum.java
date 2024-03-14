import java.util.HashMap;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        int cumsum = 0;
        int ans = 0;
        hp.put(0, 1); 
        for (int num : nums) {
            cumsum += num;
            int k = cumsum - goal;
            ans += hp.getOrDefault(k, 0);
            hp.put(cumsum, hp.getOrDefault(cumsum, 0) + 1); // Update the count of current cumulative sum
        }
        return ans;
    }
}

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length/3][3];

        int index=0;
        for(int i=0; i<nums.length; i=i+3) {
            if(nums[i+2]-nums[i] <= k) {
                ans[index][2] = nums[i+2];
                ans[index][0] = nums[i];
                ans[index][1] = nums[i+1];
                index++;
            }
            else {
                return new int[0][0];
            }
        }
        return ans;
    }
}
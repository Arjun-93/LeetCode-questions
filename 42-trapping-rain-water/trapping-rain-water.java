class Solution {
    public int trap(int[] a) {
        int n = a.length;
        int left = 0;
        int right = n - 1;
        int leftmax = 0;
        int rightmax = 0;
        int ans = 0;
        while(left <= right){
            if(a[left] <= a[right]){
                if (a[left] >= leftmax ) leftmax = a[left];
                else ans += (leftmax - a[left]);
                left++;
            }
            else{
                if(a[right] >= rightmax) rightmax = a[right];
                else ans += (rightmax - a[right]);
                right--;
            }
        }
        return ans;
    }
}
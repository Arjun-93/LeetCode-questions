class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> st = new ArrayList<>();
        Arrays.sort(nums2);
        Arrays.sort(nums1);
        int n = nums1.length;
        int m = nums2.length;

        int  i =0; 
        int j =0;
        while (i<n && j<m){
            if(nums1[i] == nums2[j]) {
                st.add(nums1[i]);
                while( i < n-1 && nums1[i] == nums1[i+1]){
                    i++;
                }
                while( j < m-1 && nums2[j] == nums2[j+1]){
                    j++;
                }
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }

        int[] ans = new int[st.size()];

        // Copy elements from ArrayList to int array
        for (int l = 0; l < st.size(); l++) {
            ans[l] = st.get(l);
        }
        return ans;
    }
}
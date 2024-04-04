class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') {
                cnt++;
                ans = Math.max(ans, cnt);
            }
            if(s.charAt(i) == ')') cnt--;
        }
        return ans;
    }
}
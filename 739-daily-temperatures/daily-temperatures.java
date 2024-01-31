class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // // Brute Force
        // int n = temperatures.length;
        // int [] answer = new int [n];
        // int k = 0;
        // Arrays.fill(answer, 0);
        // for(int i=0; i< n; i++){
        //     for(int j = i+1; j<n; j++){
        //         if(temperatures[j]>temperatures[i]){
        //             answer[k] = j-i;
        //             break;
        //         }
        //     }
        //     k++;
        // }
        // return answer;

        // this type of problem solve by using stack like next greater/smaller element (monotonic stack --  maintaining the order of stack either increasing or decresaing)
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
                ans[i] = 0;
            } else {
                while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = 0;
                } else {
                    ans[i] = stack.peek() - i;
                }
                
                stack.push(i);
            }
        }
        return ans;
    }
}
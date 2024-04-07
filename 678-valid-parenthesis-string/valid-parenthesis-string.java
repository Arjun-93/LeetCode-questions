class Solution {
    public boolean solve(int idx, int open, String s, int n){
        if(idx == n){ // base case index passes all the char in strings.
            return open == 0;
        }
        boolean isValid = false;
        if(s.charAt(idx) == '*'){ // when char == '*'            
            isValid |= solve(idx+1, open+1, s, n); // when * = (
            isValid |= solve(idx+1, open, s, n); // when * = ""
            if(open > 0){
                isValid |= solve(idx+1, open-1, s, n); // when * = ")"
            }
        }
        else if(s.charAt(idx) == '('){ // when char == '('
            isValid = solve(idx+1, open+1, s, n);
        }
        else if(open > 0){ // when char == ')'
            isValid = solve(idx + 1, open - 1, s, n);
        }
        return isValid;
    }

public boolean solve_memoization(int idx, int open, String s, int n, Boolean[][] dp) {
    if (idx == n) { // base case index passes all the char in strings.
        return open == 0;
    }
    if (dp[idx][open] != null) {
        return dp[idx][open];
    }
    boolean isValid = false;
    if (s.charAt(idx) == '*') { // when char == '*'
        isValid |= solve_memoization(idx + 1, open + 1, s, n, dp); // when * = (
        isValid |= solve_memoization(idx + 1, open, s, n, dp); // when * = ""
        if (open > 0) {
            isValid |= solve_memoization(idx + 1, open - 1, s, n, dp); // when * = ")"
        }
    } else if (s.charAt(idx) == '(') { // when char == '('
        isValid = solve_memoization(idx + 1, open + 1, s, n, dp);
    } else if (open > 0) { // when char == ')'
        isValid = solve_memoization(idx + 1, open - 1, s, n, dp);
    }
    return dp[idx][open] = isValid;
}

public boolean checkValidString(String s) {
    int open = 0;
    int n = s.length();
    int idx = 0;
    // return solve(idx, open, s, n);
    Boolean[][] dp = new Boolean[101][101];

    for (Boolean[] row : dp) {
        Arrays.fill(row, null);
    }
    return solve_memoization(idx, open, s, n, dp);
}
}
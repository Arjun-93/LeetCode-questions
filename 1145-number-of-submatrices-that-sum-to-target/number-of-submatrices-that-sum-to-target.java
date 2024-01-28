class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // row wise cummulative sum
        for(int i=0; i<m; i++){
            for(int j=1; j<n; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }

        // traversing in cummulative sum matrix for finding submatrices which sum equals to target
        int count = 0;

        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = c1; c2 < n; c2++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                for (int row = 0; row < m; row++) {
                    sum += matrix[row][c2] - (c1 > 0 ? matrix[row][c1 - 1] : 0);
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}
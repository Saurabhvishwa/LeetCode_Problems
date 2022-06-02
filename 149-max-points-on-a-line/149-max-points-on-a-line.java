class Solution {
    public int maxPoints(int[][] points) {
        int m = points.length;
        if(m <= 2) return m;
        int max = 2;
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                int curMax = 2;
                for(int k=0;k<m;k++){
                    if(k == i || k == j) continue;
                    if((points[i][1] - points[j][1])*(points[i][0] - points[k][0]) == (points[i][0]-points[j][0])*(points[i][1] - points[k][1])) ++curMax;
                }
                max = Math.max(max, curMax);
            }
        }
        return max;
    }
}

// points[i][1] - points[j][1]         points[i][1] - points[k][1]
// points[i][0] - points[j][0]         points[i][0] - points[k][0]
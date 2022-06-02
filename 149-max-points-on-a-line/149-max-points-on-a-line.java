class Solution {
    public int max(int[][] points){
        Map<Float, Integer> map = new HashMap<>();
        int max = 0;
        Arrays.sort(points, (a,b) ->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int i=0;i<points.length;i++){
            int curMax = 0;
            float slope = 0;
            for(int j=i+1;j<points.length;j++){
                if(points[j][0] - points[i][0] == 0) slope = Float.MAX_VALUE;
                else{
                    slope = (float)(points[j][1] - points[i][1])/(float)(points[j][0] - points[i][0]);
                }
                map.put(slope, map.getOrDefault(slope,1)+1);
                curMax = Math.max(curMax, map.get(slope));
            }
            max = Math.max(max, curMax);
            map.clear();
        }
        return max;
    }
    public int maxPoints(int[][] points) {
        int m = points.length;
        if(m <= 2) return m;
        return max(points);
        // int max = 2;
        // for(int i=0;i<m;i++){
        //     for(int j=i+1;j<m;j++){
        //         int curMax = 2;
        //         for(int k=0;k<m;k++){
        //             if(k == i || k == j) continue;
        //             if((points[i][1] - points[j][1])*(points[i][0] - points[k][0]) == (points[i][0]-points[j][0])*(points[i][1] - points[k][1])) ++curMax;
        //         }
        //         max = Math.max(max, curMax);
        //     }
        // }
        // return max;
    }
}

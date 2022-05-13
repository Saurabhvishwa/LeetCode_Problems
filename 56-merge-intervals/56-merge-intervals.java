class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] first, int[] second){
                return first[0]-second[0];
            }
        });
        int i=0, j=1, n=intervals.length;
        int count = 1;
        while(j<n){
            if((intervals[j][0]>=intervals[i][0] && intervals[j][0]<=intervals[i][1]) || (intervals[j][1]>=intervals[i][0] && intervals[j][1]<=intervals[i][1])){
                intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                intervals[j][0] = -1;
            }else{
                i = j;
                count++;
            }
            j++;
        }
        int[][] ans = new int[count][2];
        int index = 0;
        for(int[] a:intervals){
            if(a[0]!=-1){
                ans[index][0] = a[0];
                ans[index][1] = a[1];
                index++;
            }
        }
        return ans;
    }
}
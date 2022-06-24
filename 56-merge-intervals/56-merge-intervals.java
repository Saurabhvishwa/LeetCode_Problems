class Solution {
    public boolean isOverlapping(int start1, int end1, int start2, int end2){
        if(start2>=start1 && start2<=end1 || end2>=start1 && end2<=end1) return true;
        return false;
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] first, int[] second){
                return first[0]-second[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(intervals[0][0]);
        first.add(intervals[0][1]);
        ans.add(first);
        for(int i=1;i<intervals.length;i++){
            if(isOverlapping(ans.get(ans.size()-1).get(0), ans.get(ans.size()-1).get(1), intervals[i][0], intervals[i][1])){
                ans.get(ans.size()-1).set(0, Math.min(ans.get(ans.size()-1).get(0), intervals[i][0]));
                ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size()-1).get(1), intervals[i][1]));
            }else{
                List<Integer> newInterval = new ArrayList<>();
                newInterval.add(intervals[i][0]);
                newInterval.add(intervals[i][1]);
                ans.add(newInterval);
            }
        }
        int[][] result = new int[ans.size()][2];
        int index = 0;
        for(List<Integer> l : ans){
            result[index][0] = l.get(0);
            result[index++][1] = l.get(1);
        }
        return result;
    }
}
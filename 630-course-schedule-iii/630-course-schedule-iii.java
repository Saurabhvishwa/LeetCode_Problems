class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        for(int i=0,time=0;i<courses.length;i++){
            q.add(courses[i][0]);
            if((time += courses[i][0]) > courses[i][1]) time -= q.poll();
        }
        return q.size();
    }
}
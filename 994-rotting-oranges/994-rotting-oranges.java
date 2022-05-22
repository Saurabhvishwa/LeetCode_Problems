class Solution {
    public boolean isValid(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int time = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 || grid[i][j] == 2) total++;
                if(grid[i][j] == 2){
                    total--;
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] node = q.poll();
            time = node[2];
            if(isValid(node[0], node[1]+1, grid)){
                q.add(new int[]{node[0], node[1]+1, node[2]+1});
                grid[node[0]][node[1]+1] = 2;
                total--;
            }
            if(isValid(node[0]+1, node[1], grid)){
                q.add(new int[]{node[0]+1, node[1], node[2]+1});
                grid[node[0]+1][node[1]] = 2;
                total--;
            }
            if(isValid(node[0], node[1]-1, grid)){
                q.add(new int[]{node[0], node[1]-1, node[2]+1});
                grid[node[0]][node[1]-1] = 2;
                total--;
            }
            if(isValid(node[0]-1, node[1], grid)){
                q.add(new int[]{node[0]-1, node[1], node[2]+1});
                grid[node[0]-1][node[1]] = 2;
                total--;
            }
        }
        return total == 0 ? time : -1;
    }
}
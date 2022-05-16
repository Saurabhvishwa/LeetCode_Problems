class Solution {
    static class Node{
        int row;
        int col;
        int d;
        Node(int r, int c, int d){
            this.row = r;
            this.col = c;
            this.d = d;
        }
    }
    public boolean isValid(int[][] grid, int row, int col, int n){
        if(row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == 1 || grid[row][col] == -1) return false;
        return true;
    }
    public int dfs(int[][] grid , Queue<Node> q){
        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1) return -1;
        int min = Integer.MAX_VALUE;
                while(!q.isEmpty()){
                    Node curr = q.poll();
                    int r = curr.row;
                    int c = curr.col;
                    int d = curr.d;
                    if(r == grid.length-1 && c == grid.length-1 && grid[r][c] != 1){
                        min = Math.min(min, d);
                        continue;
                    }
                    if(!isValid(grid, r, c, grid.length)) continue;
                    grid[r][c] = -1;
                    if(isValid(grid, r, c+1, grid.length)){
                        q.add(new Node(r, c+1, d+1));
                    }
                    if(isValid(grid, r+1, c+1, grid.length)){
                        q.add(new Node(r+1, c+1, d+1));
                    }
                    if(isValid(grid, r+1, c, grid.length)){
                    q.add(new Node(r+1, c, d+1));
                        
                    }
                    if(isValid(grid, r+1, c-1, grid.length)){
                    q.add(new Node(r+1, c-1, d+1));
                        
                    }
                    if(isValid(grid, r, c-1, grid.length)){
                        q.add(new Node(r, c-1, d+1));
                    }
                    if(isValid(grid, r-1, c-1, grid.length)){
                        q.add(new Node(r-1, c-1, d+1));
                    }
                    if(isValid(grid, r-1, c, grid.length)){
                        q.add(new Node(r-1, c, d+1));
                    }
                    if(isValid(grid, r-1, c+1, grid.length)){
                        q.add(new Node(r-1, c+1, d+1));
                    }
                    
                }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        return dfs(grid , q);
    }
}
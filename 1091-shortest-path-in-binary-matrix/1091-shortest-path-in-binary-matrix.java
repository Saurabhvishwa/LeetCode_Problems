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
    public boolean isValid(int[][] grid, int row, int col, boolean[][] visited, int n){
        if(row < 0 || row >= n || col < 0 || col >= n || visited[row][col] == true || grid[row][col] == 1) return false;
        return true;
    }
    public int dfs(int[][] grid, boolean[][] visited, Queue<Node> q , int[] ans){
                while(!q.isEmpty()){
                    Node curr = q.poll();
                    int r = curr.row;
                    int c = curr.col;
                    int d = curr.d;
                    if(r == grid.length-1 && c == grid.length-1 && grid[r][c] != 1){
                        ans[0] = Math.min(ans[0], d);
                        continue;
                    }
                    if(!isValid(grid, r, c, visited, grid.length)) continue;
                    visited[r][c] = true;
                    q.add(new Node(r, c+1, d+1));
                    q.add(new Node(r+1, c+1, d+1));
                    q.add(new Node(r+1, c, d+1));
                    q.add(new Node(r+1, c-1, d+1));
                    q.add(new Node(r, c-1, d+1));
                    q.add(new Node(r-1, c-1, d+1));
                    q.add(new Node(r-1, c, d+1));
                    q.add(new Node(r-1, c+1, d+1));
                    
                }
        return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] ans = {Integer.MAX_VALUE};
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        boolean[][] visited = new boolean[grid.length][grid.length];
        return dfs(grid, visited, q, ans);
    }
}
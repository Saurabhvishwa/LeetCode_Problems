class Solution {
    public int[][] getShiftedGrid(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int temp = grid[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int el;
                if(i == 0 && j==0){
                    continue;
                }
                if(i == m-1 && j == n-1){
                    el = grid[i][j];
                    grid[i][j] = temp;
                    grid[0][0] = el;
                }else{
                    el = grid[i][j];
                    grid[i][j] = temp;
                    temp = el;
                }
            }
        }
        return grid;
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for(int i=0;i<k;i++){
            grid = getShiftedGrid(grid);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            List<Integer> list = Arrays.stream(grid[i]).boxed().toList();
            result.add(list);
        }
        return result;
    }
}
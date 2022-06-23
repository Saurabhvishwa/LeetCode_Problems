class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        triangle.add(first);
        for(int i=1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j == 0 || j == i) row.add(1);
                else row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }
}
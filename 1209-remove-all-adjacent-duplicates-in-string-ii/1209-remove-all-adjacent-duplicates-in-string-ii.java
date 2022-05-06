class Solution {
    public String removeDuplicates(String S, int k) {
        char[] arr = S.toCharArray();
            Stack<Integer> st = new Stack<>();
        int i,j;
        st.push(0);
        for(i=1,j=1;j<arr.length;i++,j++){
            char temp = arr[i] = arr[j];
            if(i == 0 || temp != arr[i-1]) st.push(i);
            else if( i - st.peek() +1 == k) i = st.pop()-1;
        }
        return new String(arr, 0, i);
    }
}
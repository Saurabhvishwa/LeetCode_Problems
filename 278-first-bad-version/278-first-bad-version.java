/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start, end, middle;
        start = 1;
        end = n;
        int index = 1;
        while(start<=end){
            // ensure you calculate mid values this way ,otherwise ,it would cause overflow
            middle = start+ (end-start)/2;
            boolean x = isBadVersion(middle);
            if(x == true){
                index = middle;
                end = middle-1;
            }
            else
                start = middle+1;
        }

        // return the first index of faulty product
        return index;
    }
}
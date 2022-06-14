class MedianFinder {
    PriorityQueue<Integer> max, min;
    public MedianFinder() {
        max = new PriorityQueue<>((a,b) -> b-a);
        min = new PriorityQueue<>((a, b) -> a-b);
    }
    
    public void addNum(int num) {
        if(max.size() == 0 && min.size() == 0) max.add(num);
        else{
            if(max.size() == min.size()+1){
                int top = max.peek();
                if(top > num){
                    min.add(top);
                    max.poll();
                    max.add(num);
                }else{
                    min.add(num);
                }
            }else{
                int top = max.peek();
                if(num<=top) {max.add(num); return;}
                top = min.peek();
                if(num<=top) max.add(num);
                else{
                    int other = min.poll();
                    min.add(num);
                    max.add(other);
                }
            }
        }
    }
    
    public double findMedian() {
        if((max.size()+min.size())%2 == 0){
            double a = max.peek(), b = min.peek();
            return (a+b)/2.0;
        }
        else return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
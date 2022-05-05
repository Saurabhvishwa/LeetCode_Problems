class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        int element;
        int size = queue.size();
        size--;
        while(size>0){
            element = queue.poll();
            queue.add(element);
            size--;
        }
        
        return queue.poll();
    }
    
    public int top() {
        int element = 0;
        int size = queue.size();
        while(size>0){
            element = queue.poll();
            queue.add(element);
            size--;
        }
        return element;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
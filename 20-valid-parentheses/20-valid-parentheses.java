class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int index = 0;
        while(index<n){
            char c = s.charAt(index);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if(stack.empty()) return false;
                else{
                    char prev = stack.pop();
                    if(prev!='{' && c=='}' || prev!='[' && c==']' || prev!='(' && c==')'){
                        return false;
                    }
                }
            }
            index++;
        }
        return stack.empty() == true;
    }
}
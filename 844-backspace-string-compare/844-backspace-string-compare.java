class Solution {
    public boolean checkBS(String s, String t){
        StringBuilder a = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '#'){
                if(a.length()>0){
                    a.replace(a.length()-1, a.length(),"");
                }
            }else{
                a.append(String.valueOf(s.charAt(i)));
            }
        }
       StringBuilder b = new StringBuilder("");
        for(int i=0;i<t.length();i++){
            if(t.charAt(i) == '#'){
                if(b.length()>0){
                    b.replace(b.length()-1, b.length(),"");
                }
            }else{
                b.append(String.valueOf(t.charAt(i)));
            }
        }
        return a.toString().equals(b.toString());
    }
    public boolean backspaceCompare(String s, String t) {
//       Stack<Character> a = new Stack<>();
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i) == '#'){
//                 if(a.size() > 0){
//                     a.pop();
//                 }
//             }else{
//                 a.push(s.charAt(i));
//             }
//         }
//          Stack<Character> b = new Stack<>();
//         for(int i=0;i<t.length();i++){
//             if(t.charAt(i) == '#'){
//                 if(b.size() > 0){
//                     b.pop();
//                 }
//             }else{
//                 b.push(t.charAt(i));
//             }
//         }
//         if(a.size() != b.size()) return false;
        
//         while (!a.empty()){
//             if (a.peek() == b.peek()){
//                 a.pop();
//                 b.pop();
//             }
//             else{
//                 return false;
//             }
//         }
        return checkBS(s, t);
        
    }
}
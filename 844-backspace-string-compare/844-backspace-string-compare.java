class Solution {
    public boolean backspaceCompare(String s, String t) {
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
}
class Solution {
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        int n = path.length();
        String[] arr = path.split("/");
        for(String s:arr){
            if(s.equals(".") || s.length() == 0){
                continue;
            }else if(s.equals("..")){
                if(list.size()>0){
                    list.remove(list.size()-1);
                }
            }else{
                list.add(s);
            }
        }
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for(String s: list){
            sb.append("/").append(s);
        }
        return sb.toString().length() == 0 ? "/" : sb.toString();
    }
}
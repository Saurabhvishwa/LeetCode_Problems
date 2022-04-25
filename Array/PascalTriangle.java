import java.util.*;
import java.io.*;

class PascalTriangle{

  public static List<Integer>[] findPascalTraingle(int n){
        List<Integer>[] list = new ArrayList[n];
        list[0] = new ArrayList<>();
        list[0].add(1);
        for(int i=1;i<n;i++){
            list[i] = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j == 0){
                    list[i].add(list[i-1].get(j));
                }else if(j > 0 && j<i){
                    list[i].add(list[i-1].get(j)+list[i-1].get(j-1));
                }else{
                    list[i].add(list[i-1].get(list[i-1].size()-1));
                }
            }
        }
        return list;
    }

}

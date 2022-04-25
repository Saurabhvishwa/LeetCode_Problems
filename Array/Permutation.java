/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Permutation
{
    public static List<String> getAllPermutations(String s){
      List<String> result = new ArrayList<>();
      StringBuilder sbr;
        for(int i=0;i<s.length();i++){
            for(int j = i;j<s.length();j++){
              sbr = new StringBuilder();
                for(int k=i;k<=j;k++){
                    sbr.append(s.charAt(k));
                }
              result.add(sbr.toString());
            }
        }
          
         return result; 
       
    }
}

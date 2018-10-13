/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package specialstrings;

import java.util.Scanner;
import java.util.Stack;

public class SpecialStrings {


   public static void main(String[] args) {
  
       permuteit("aab","");

}
    public static void permuteit(String str,String ans){
        if(str.length()==0){
                    System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);
        for (int i = 0; i <= ans.length(); i++) {
            String left = ans.substring(0, i);
            String right = ans.substring(i);
            permuteit(roq, right + ch + left);

        }
    }
}

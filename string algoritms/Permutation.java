/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package specialstrings;

import java.util.Scanner;
import java.util.Stack;

public class SpecialStrings {


   public static void main(String[] args) {
  
      String str = new String("abc");
      System.out.println("the permutations of : " + str);
      Stack temp=new Stack();
      Stack perm=new Stack();

      perm.push(str.charAt(str.length()-1));
      int i,j;
      for(i=str.length()-2;i>=0;i--){
                char ch=str.charAt(i);
                 System.out.println("play with : "+ch);
                  System.out.println("perm"+perm);
       while(perm.isEmpty()!=true){

           String spp=perm.pop().toString();
           StringBuilder s=new StringBuilder(spp);
           int len=s.length();
            System.out.println("s before : "+s);
             StringBuilder stp=new StringBuilder(s);
           for(j=0;j<len;j++){
               s.insert(j,ch);
                System.out.println("s  : "+s);
                temp.push(s);
                s=stp;

           }
          



       }
       while(temp.isEmpty()!=true){
       perm.push(temp.pop());

       }

      }
/*
      System.out.println("perm"+perm);
      System.out.println("temp"+temp);
*/
   
   }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suffixarray;

/**
 *
 * @author samsung
 */
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class SuffixArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String st = "ABCDABE";
        int leng = st.length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        String arr[] = new String[leng];
        int i;
        for (i = 0; i < leng; i++) {
            String sp = st.substring(i, leng);
            //System.out.println(sp);
            map.put(sp, i);


        }
        i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            arr[i] = key;
             
            i++;

        }
       
     Arrays.sort(arr);
     int suffix_array[]=new int[leng];
        for (i = 0; i < leng; i++) {
         suffix_array[i]=map.get(arr[i]);
      //  System.out.println(suffix_array[i]);}

     ///////pattern searching process//////

     String pat="AB";
     int pat_leng=pat.length();
     int end=leng-1,beg=0,mid;
outer:
     while(beg<=end){

     mid=(beg+end)/2;

     int res=pat.compareTo(st.substring(suffix_array[mid],suffix_array[mid]+pat_leng));
     if(res==0){
     System.out.println("string found At : "+suffix_array[mid]);break;}
     else {if(res<0){
     end=mid;
     }
     else{
     beg=mid+1;

     }
     }

     }




       

    }}}


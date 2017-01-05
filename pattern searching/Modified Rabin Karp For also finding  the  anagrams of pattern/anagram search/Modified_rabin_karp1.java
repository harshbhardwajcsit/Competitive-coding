/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modified_rabin_karp1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author samsung
 */
public class Modified_rabin_karp1 {
    // LOGIC - to find whether the Permutation are present in text or to find the position of that anagrams , just check that all character
    //of the pattern should be there in targeted text because all anagrams are composed of the repeated character

    //for ex-ABC have anagrams ABC ACB BCA BAC CAB CBA
    // ALL contains characters of the text ABC ,so just find the avability of each word in the sub text ,that's easy !

    // NOTE : this techniques will still work if the Characters will repeat in targeted test ex. ABBC


    public static void main(String[] args) {
        Map<Character,Character> map=new HashMap<Character,Character>();
        Map<Character,Character> Temp_map=new HashMap<Character,Character>();

        String text1="ABCDGMDBCAQRCBAD"; char t1[]=text1.toCharArray();
        String text2="ABMCGMDBBAQRCBAD";char t2[]=text2.toCharArray();
        String pattern="ABC";char p[]=pattern.toCharArray();

         int i=0,k=0;
         int char_frequency=0;//freauency of character in pattern
         int Target_text=0; //frequecy of characters in text targeted part !!
        for(i=0;i<p.length;i++){

            if(map.containsKey(p[i])==false){ //if this is new value
            map.put(p[i],p[i]);
            char_frequency++;


            }} //Storing pattern in map

         i=0;

    while(i<t1.length){
   // System.out.println("i"+i);
        if(map.containsKey(t1[i])==true){//check for each charater
        k++;
        System.out.println(i+"->"+k);
        //System.out.println(i+"->"+k);
        if(Temp_map.containsKey(t1[i])==false){Temp_map.put(t1[i],t1[i]);Target_text++;
        //first store values in temp map
        }
      
        if(k==p.length){
        System.out.println("targeted text frequency :"+Target_text);
      //  System.out.println(i+"->"+k);
        if(char_frequency==Target_text) //compare both freaquecy to reduce problems of repeated character
        {System.out.print("Pattern found at: "+(i-(p.length-1)));
        System.out.println("\n");

        k=0;
        Target_text=0;
        Temp_map.clear();
        i++;
        }else{
         k=0;
         Target_text=0;
        Temp_map.clear();
        i++;
        }}
        else{i++;}


        }
        else{


        k=0;
         Target_text=0;
        Temp_map.clear();
        i++;}


    }
}}









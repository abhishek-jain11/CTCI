import java.util.HashMap;
import java.util.Map;

/**
 * Created by AJ on 5/20/17.
 */
public class Solution {

    private static boolean isPalindromePermutation(String inp){

        Map<Character,Integer> characterMap = new HashMap<Character,Integer>();
        int numberOfSpaces = 0;

        for(Character c: inp.toCharArray()){
           Character ch  = Character.toLowerCase(c);
           if(ch==' '){
               numberOfSpaces++;
               continue;
           }
             if(characterMap.get(ch)!=null){
                 characterMap.put(ch,characterMap.get(ch)+1);
             }else{
                 characterMap.put(ch,1);
             }

        }

//Conditions for palindrome
        //Odd length string - One character in odd number - Rest all Even
        //Even length String - All Even

        if(inp.length()%2==0){
            for(Map.Entry<Character,Integer> entry: characterMap.entrySet()){
                Integer occurences = entry.getValue();
                if(occurences%2!=0){
                    if(numberOfSpaces>0){
                        numberOfSpaces--;
                        continue;
                    }
                    return false;
                }
            }
        }else{
            boolean oneOddOccurence = false;
            for(Map.Entry<Character,Integer> entry: characterMap.entrySet()){
                Integer occurences = entry.getValue();
                if(occurences%2!=0 && !oneOddOccurence){
                    oneOddOccurence = true;
                }else if(occurences%2!=0 && oneOddOccurence){
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String args[]){

        String input = "Tact Coa";

        System.out.println(isPalindromePermutation(input));

    }
}

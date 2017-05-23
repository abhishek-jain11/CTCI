/**
 * Created by AJ on 5/22/17.
 */
public class Solution {

    public static String compressedString(String input){
        String compressedString ="";
        int counter=1;

        char[] charArray = input.toCharArray();
        char prevCharacter=charArray[0];
        for(int i=1;i<charArray.length;i++){
            char currentChar=charArray[i];
            if(prevCharacter==currentChar){
                counter++;
                prevCharacter=currentChar;
            }else{
                compressedString+=prevCharacter+""+counter;
                counter=1;
                prevCharacter=currentChar;
            }
        }
        compressedString+=prevCharacter+""+counter;

        if(compressedString.length()>=input.length()){
            return input;
        }

        return compressedString;
    }

    public static void main(String args[]){
        String  inp ="aabcccccaaa";
        System.out.println(compressedString(inp));
    }
}

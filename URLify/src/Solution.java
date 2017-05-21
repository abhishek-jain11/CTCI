/**
 * Created by AJ on 5/20/17.
 */
public class Solution {

    private static String urlify(char[] charArr){

        int idx = charArr.length -1;
        int i = charArr.length -1;
     //   char[] charArr = inp.toCharArray();
        while(i>0){
            if(charArr[i]==' '){
                i=i-1;
            }else{
                break;
            }
        }
    //i=inp.length()-1;
        while(i>0){
            if(charArr[i]!=' '){
                charArr[idx--] = charArr[i--];
            }else{
                charArr[idx--]='0';
                charArr[idx--]='2';
                charArr[idx--]='%';
                i--;
            }
        }

        return String.valueOf(charArr);
    }

    public static void main(String args[]){
        String input = "Mr John Smith    ";

        String output = urlify(input.toCharArray());

        System.out.println(output);
    }
}

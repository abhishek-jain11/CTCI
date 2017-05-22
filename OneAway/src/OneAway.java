import java.util.HashMap;
import java.util.Map;

/**
 * Created by AJ on 5/21/17.
 */
public class OneAway {

    public static boolean oneAway(String inp, String inp2){

        String referenceList = inp.length()<inp2.length()?inp:inp2;
        String compareString = referenceList==inp?inp2:inp;

        Map<Character,Integer> cMap = new HashMap<Character,Integer>();
        for(Character c : referenceList.toCharArray()){
            if(cMap.get(c)!=null){
                cMap.put(c,cMap.get(c)+1);
            }else{
                cMap.put(c,1);
            }
        }

        Character unMatchedCharacter = null;
        for(Character c: compareString.toCharArray()){
            if(cMap.get(c)==null){
                if(unMatchedCharacter!=null){
                    return false;
                }
                unMatchedCharacter=c;
            }else{
                Integer occurence = cMap.get(c)-1;
                if(occurence>1){
                    cMap.put(c,occurence);
                }else{
                    cMap.remove(c);
                }
            }
        }

        return true;
    }

    public static void main(String args[]){

        String inp = "pale";
        String inp2 = "ple";
        System.out.print(oneAway(inp,inp2));
    }
}

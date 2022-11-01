import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        
    HashMap<String, Integer> map = new HashMap<>();
    for(String number : phone_book){
        for(int i=1;i<number.length();i++){
            map.put(number.substring(0,i),i);
        }
    }       
    for(String number : phone_book){
        if(getAnswer(number,map)) return false;
    }
    return true;
    }
    
    public static boolean getAnswer(String number, HashMap<String,Integer> map){
        if(map.containsKey(number)) return true;
        return false;
    }
}
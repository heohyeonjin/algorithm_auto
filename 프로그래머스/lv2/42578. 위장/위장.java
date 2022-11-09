import java.util.*;
class Solution {
    static int combi[];
    static boolean visited[];
    static String type[];
    static HashMap<String, ArrayList<String>> clothesMap = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 1;
        for(String [] cloth : clothes){
            makeClothesMap(clothesMap, cloth);    
        }
        
        for(String tmp : clothesMap.keySet()){
            answer*=(clothesMap.get(tmp).size()+1); 
        }
        answer--; // 모두 선택 안한 경우
        return answer;
    }
    public static void makeClothesMap(HashMap<String, ArrayList<String>> clothesMap, String [] cloth){
        String name = cloth[0];
        String type = cloth[1];
        if(clothesMap.containsKey(type)){
            clothesMap.get(type).add(name);
        }
        else{
            clothesMap.put(type, new ArrayList<String>(Arrays.asList(name)));
        }
    }
}
    
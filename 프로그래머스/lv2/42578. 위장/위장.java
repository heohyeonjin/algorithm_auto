import java.util.*;
class Solution {
    static int combi[];
    static boolean visited[];
    static String type[];
    static HashMap<String, ArrayList<String>> clothesMap = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 1;
        // headgear --> yello_hat, green_turban
        // eyewear --> blue_sunglasses, red_amn
        // outer --> black_swan, white_shirt
        // 3C1, 3C2, 3C3
        for(String [] cloth : clothes){
            makeClothesMap(clothesMap, cloth);    
        }
        
        for(String tmp : clothesMap.keySet()){
            answer*=(clothesMap.get(tmp).size()+1);
        }
        answer--; // 모두 선택 안한 경우
//         type = new String[clothesMap.size()];
//         makeTypeList(clothesMap);
        
//         visited = new boolean[clothesMap.size()];
//         for(int i=1;i<=clothesMap.size();i++){
//             combi = new int[i];
//             getCombi(0,clothesMap.size(),i);
//         }
      
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
    
//     public static void makeTypeList(HashMap<String, ArrayList<String>> clothesMap){
//         int i=0;
//         for(String tmp : clothesMap.keySet()){
//            type[i++] = tmp;
//        }
//     }
//     public static void getCombi(int depth, int n, int r){
//         if(depth==r){
//             getNumOfCombi();
//             return;
//         }
        
//         for(int i=depth; i<n; i++){
//             if(!visited[i]){
//                 visited[i] = true;
//                 combi[depth] = i;
//                 getCombi(depth+1,n,r);
//                 visited[i] = false;
//             }
//         }
//     }
//     public static void getNumOfCombi(){
//         int cases =1;
//         for(int x : combi){
//             String tmp = type[x];
//             int cloth_num = clothesMap.get(tmp).size();
//             cases*=cloth_num;
//         }
//         answer+=cases;
//     }
// }
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String s_numbers[] = new String[numbers.length];
        
        // 문자열은 사전 순 정렬함
        for(int i=0;i<numbers.length;i++) { 
         s_numbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(s_numbers,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2); // 큰게 더 작은게 맞다 --> 오름차순
            }
        });
        
        if(s_numbers[0].equals("0")) return "0";
        
        for(int i=0;i<s_numbers.length;i++){
            answer+=s_numbers[i];
        }
        
        return answer;
    }
}
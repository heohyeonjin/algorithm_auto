import java.util.*;
class Solution {
    static int output[];
    static int oper[] ={-1,1};
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        int len = numbers.length;
        output = new int[len];
        // +,-를 중복 순열 numbers의 개수만큼 
        dfs(0,len,target,numbers);
        return answer;
    }
    public static void dfs(int depth, int len, int target, int[] numbers){
        
        if(depth==len){
            int sum = 0;
            for(int i=0;i<len;i++){
                sum+=numbers[i]*output[i];
            }
            if(sum==target) {
                answer++;
            }

            return;
        }
        
        for(int i=0;i<2;i++){
            output[depth] = oper[i];
            dfs(depth+1,len,target,numbers);
            
        }
    }
}
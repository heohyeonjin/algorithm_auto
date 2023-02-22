import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.offer(scoville[i]);
        }
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur>=K) break;
            else{
                if(pq.isEmpty()){
                    return -1;
                }
                int ncur = pq.poll();
                pq.offer(cur+ncur*2);
                answer++;
            }
        }
        return answer;
    }
}
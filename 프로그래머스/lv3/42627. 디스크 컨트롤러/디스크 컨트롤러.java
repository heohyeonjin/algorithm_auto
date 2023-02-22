import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1,o2) -> o1[0]-o2[0]); // 요청 순서 빠른 순
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]); // 소요 시간 짧은 순
        
        int process = 0;
        int processIdx = 0; // 처리 한 작업
        int endTime = 0;
        while(process<jobs.length){
            if(process==jobs.length) break; // 작업 처리 완료
            
            for(int i=0;i<jobs.length;i++){
               if(processIdx>i) continue;
                
               if(jobs[i][0]<=endTime){
                   pq.offer(jobs[processIdx++]); // 처리 가능한 작업
               }
            }
            
            if(pq.isEmpty()){
                endTime = jobs[processIdx][0];
            }
            else{
                int temp[] = pq.poll();
                answer+=temp[1] + endTime-temp[0];
                endTime+=temp[1];
                process++;
            }
            
        }
        
        return answer/jobs.length;
    }
}
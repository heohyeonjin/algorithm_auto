import java.io.*;
import java.util.*;
public class Main {
    static int S;
    static int emo_clip[] = new int[1001];
    static boolean visited[][] = new boolean[1001][1001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        int answer = BFS();
        System.out.println(answer);
    }
    public static int BFS(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0});
        int phase = 0;
        boolean flag = false;
        while(!queue.isEmpty()){
            int queueLen = queue.size();
            for(int j=0; j<queueLen; j++){
                int cur[] = queue.poll();
                if(cur[0]==S){
                    flag = true;
                    break;
                }
                int cur_emo = 0;
                int cur_clip = 0;
                for(int i=0; i<3; i++){
                    if(i==0){ // 복사
                        cur_emo  = cur[0];
                        cur_clip = cur[0];
                    }
                    else if(i==1){ // 붙여넣기
                        if(cur[1]!=0){
                            cur_emo = cur[0]+cur[1];
                            cur_clip = cur[1];
                        }
                    }
                    else{ //삭제
                        cur_emo = cur[0]-1;
                        cur_clip = cur[1];
                    }
                    if(cur_emo>=0 && cur_clip>=0 && cur_emo<=1000) {
                        if (!(cur_emo == 0 && cur_clip == 0)) {
                            if (!visited[cur_emo][cur_clip]) {
                                visited[cur_emo][cur_clip] = true;
                                queue.offer(new int[]{cur_emo, cur_clip});
                            }
                        }
                    }
                }
            }
            if(flag) break;
            phase++;
        }
        return phase;
    }
}

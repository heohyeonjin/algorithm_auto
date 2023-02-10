// RGB 거리
import java.io.*;
public class Main {
    static int N;
    static int paintCost[][];
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 집의 수

        paintCost = new int[N][3];
        for(int i=0;i<N;i++){
            String input[] = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                paintCost[i][j] = Integer.parseInt(input[j]);
            }
        }
        dp = new int[N][3];
        dp[0][0] = paintCost[0][0];
        dp[0][1] = paintCost[0][1];
        dp[0][2] = paintCost[0][2];

        System.out.println(Math.min(Math.min(DFS(N-1, 0), DFS(N-1, 1)),DFS(N-1,2)));
    }

    public static int DFS(int N, int color_idx){

        if(dp[N][color_idx]==0){
            if(color_idx==0){ // 빨강
                dp[N][color_idx] = Math.min(DFS(N-1, 1), DFS(N-1, 2))+paintCost[N][color_idx];
            }
            else if(color_idx==1){ // 초록
                dp[N][color_idx] = Math.min(DFS(N-1,0), DFS(N-1,2))+paintCost[N][color_idx];
            }
            else{ // 파랑
                dp[N][color_idx] = Math.min(DFS(N-1,0),DFS(N-1,1))+paintCost[N][color_idx];
            }
        }

        return dp[N][color_idx];
    }
}

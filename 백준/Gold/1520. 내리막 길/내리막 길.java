import java.io.*;
import java.util.*;

// 내리막길
public class Main {
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};
    static int M,N;
    static int arr[][];
    static int dp[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        arr = new int[M][N];
        dp = new int[M][N]; // x,y에서 도착점으로 가는 경우의 수
        for(int i=0;i<M;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(input[j]);
                dp[i][j] = -1;
            }
        }
        
        dfs(0,0);
        System.out.println(dp[0][0]);

    }
    public static int dfs(int row, int col){

        if(row==M-1 && col==N-1){
            return 1;
        }

        if(dp[row][col]!=-1) return dp[row][col];

        dp[row][col] = 0;
        for(int i=0;i<4;i++){
            int n_row = dir_row[i]+row;
            int n_col = dir_col[i]+col;

            if(n_row>=0 && n_col>=0 && n_row<M && n_col<N){
                if(arr[row][col]>arr[n_row][n_col]){
                    dp[row][col]+=dfs(n_row,n_col);
                }
            }
        }
        return dp[row][col];
    }
}

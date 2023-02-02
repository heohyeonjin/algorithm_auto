import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int arr[][];
    static int answer = Integer.MIN_VALUE;
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};
    static int dp[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];
        for(int i=0;i<N;i++){
            String input[] = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(input[j]);
                dp[i][j] = -1;

            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int result = dfs(i,j);
                answer = Math.max(result,answer);
            }
        }


        System.out.println(answer);
    }
    public static int dfs(int row, int col){

        if(dp[row][col]!=-1) return dp[row][col];


        dp[row][col] = 1;

        for(int i=0;i<4;i++){
            int n_row = row+dir_row[i];
            int n_col = col+dir_col[i];

            if(n_row>=0 && n_col>=0 && n_row<N & n_col<N){
                if(arr[row][col]<arr[n_row][n_col]){
                    dp[row][col] = Math.max(dp[row][col],dfs(n_row,n_col)+1);
                }
            }
        }
        return dp[row][col];
    }
}

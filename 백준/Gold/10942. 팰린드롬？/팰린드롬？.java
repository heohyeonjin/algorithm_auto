import java.io.*;
import java.util.*;

// 팰린드롬?
public class Main {
    static boolean dp[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N+1][N+1];
        setDp(arr,N);
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(dp[start][end]){
                sb.append("1\n");
            }
            else{
               sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
    public static void setDp(int arr[], int N){

        for(int i=1;i<=N;i++){ // 길이 1
            dp[i][i] = true;
        }

        for(int i=1;i<N;i++){ // 길이 2
            if(arr[i]==arr[i+1]){
                dp[i][i+1] = true;
            }
        }

        for(int i=2;i<=N;i++){
            for(int j=1;j+i<=N;j++){
                if(dp[j+1][j+i-1] && arr[j] == arr[j+i]){
                    dp[j][j+i] = true;
                }
            }
        }


    }
}

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T[] = new int[N];
        int P[] = new int[N];

        for(int i=0;i<N;i++){
            String input[] = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        int dp[] = new int[N+1];
        int answer = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int nextDay = i+T[i]; // 상담 가능한 시작 날짜
            if(nextDay<=N){
                dp[nextDay] = Math.max(dp[nextDay],dp[i]+P[i]);
            }
            dp[i+1]=Math.max(dp[i],dp[i+1]); // 이걸 빠뜨림.. 상담은 연속적으로 이루어짐
            answer = Math.max(answer,dp[i+1]);
        }

        System.out.println(answer);


    }
}

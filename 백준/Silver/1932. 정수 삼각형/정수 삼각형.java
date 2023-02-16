import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n];

        for(int i=0;i<n;i++){
            if(i==0){
                dp[0] = Integer.parseInt(br.readLine());
            }
            else{
                String input[] = br.readLine().split(" ");
                int tmp[] = new int[input.length];
                for(int j=0;j<input.length;j++){
                    int cur = Integer.parseInt(input[j]);
                    if(j-1==-1){
                        tmp[j] = dp[j]+cur;
                    }
                    else{
                        tmp[j] = Math.max(dp[j],dp[j-1])+cur;
                    }
                }
                for(int ch = 0 ;ch<tmp.length;ch++){
                    dp[ch] = tmp[ch];
                }
            }
//            System.out.println(Arrays.toString(dp));
        }
        int answer = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            answer = Math.max(dp[i],answer);
        }
        System.out.println(answer);
    }
}

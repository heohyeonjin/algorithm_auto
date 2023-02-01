import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        int answer = LCS(input1, input2);
        System.out.println(answer);
    }

    public static int LCS(String input1, String input2){
        int max = Integer.MIN_VALUE;
        int dp[][] = new int[input1.length()+1][input2.length()+1];

        for(int i=0;i<input1.length();i++){
            for(int j=0;j<input2.length();j++){
                if(input1.charAt(i)==input2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                    max = Math.max(max,dp[i+1][j+1]);
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        
        if(max==Integer.MIN_VALUE) max = 0;
        return max;
    }
}


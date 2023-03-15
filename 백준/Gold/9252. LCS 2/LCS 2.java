import java.io.*;
public class Main {
    static int dp[][];
    static String input1;
    static String input2;
    static int Row;
    static int Col;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input1 = br.readLine();
        input2 = br.readLine();

        int input1Len = input1.length();
        int input2Len = input2.length();
        dp = new int[input2Len+1][input1Len+1];
        for(int i=0;i<input1Len;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<input2Len;i++){
            dp[i][0] = 0;
        }
        int maxValue = findMaxValue();
        String alpha = findMaxAlphabet();
        if(maxValue==0){
            System.out.println(0);
        }
        else{
            System.out.println(maxValue);
            System.out.println(alpha);
        }
    }
    public static int findMaxValue(){
        int MaxValue = Integer.MIN_VALUE;
        for(int i=1;i<=input2.length();i++){
            for(int j=1;j<=input1.length();j++){
                if(input1.charAt(j-1)!=input2.charAt(i-1)){
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(MaxValue<dp[i][j]){
                    MaxValue = dp[i][j];
                    Row = i;
                    Col = j;
                }
            }
        }
        return MaxValue;
    }

    public static String findMaxAlphabet(){
        StringBuilder sb = new StringBuilder();

        while(true){
            if(dp[Row][Col]==0) break;
            if(input1.charAt(Col-1)==input2.charAt(Row-1)){
                sb.append(input2.charAt(Row-1));
                Row-=1;
                Col-=1;
            }
            else{
               if(dp[Row][Col]==dp[Row][Col-1]){
                   Col-=1;
               }
               else if(dp[Row][Col]==dp[Row-1][Col]){
                   Row-=1;
               }
               else{
                   Row-=1;
                   Col-=1;
               }
            }
        }
        return sb.reverse().toString();
    }
}

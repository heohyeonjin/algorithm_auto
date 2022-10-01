import java.io.*;
import java.util.*;
class Main{
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int coin[] = new int[N];
            String str[] = br.readLine().split(" ");
            for(int j=0;j<N;j++) coin[j] = Integer.parseInt(str[j]);
            int money = Integer.parseInt(br.readLine());
            DP(coin,money);
        }
        for(Integer x : answer) System.out.println(x);
    }
    public static void DP(int coin[], int money){
        int dp[] = new int[money+1];
        dp[0] = 1;

        for(int i=0;i<coin.length;i++){
            for(int j=coin[i];j<=money;j++){
                dp[j]+=dp[j-coin[i]];
            }
        }
       answer.add(dp[money]);
    }
}
// 회사 문화 1
import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer> graph[];
    static int dp[];
    static int n,m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        input = br.readLine().split(" ");
        for(int i=1;i<n;i++){
            int pre = Integer.parseInt(input[i]);
            graph[pre].add(i+1);
        }

        dp = new int[n+1];
        for(int i=0;i<m;i++){
            input = br.readLine().split(" ");
            int cus = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            dp[cus] +=w;
        }
        dfs(1);
        for(int i=1;i<=n;i++){
            System.out.print(dp[i]+" ");
        }
    }
    public static void dfs(int start){
        for(int next : graph[start]){
            dp[next] += dp[start];
            dfs(next);
        }
    }
}

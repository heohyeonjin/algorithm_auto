import java.io.*;
import java.util.*;
class Country implements Comparable<Country>{
    public int v;
    public int cost;

    public Country(int v, int cost){
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Country o){
        if(this.cost==o.cost){
            return this.v-o.v;
        }
        return this.cost-o.cost;
    }
}
public class Main {
    static ArrayList<Country> graph[];
    static int dp[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            graph[a].add(new Country(b, cost));
        }

        visited = new boolean[N+1];
        dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        String input[] = br.readLine().split(" ");
        int from = Integer.parseInt(input[0]);
        int to = Integer.parseInt(input[1]);
        System.out.println(BFS(from,to,0));
    }

    public static int BFS(int v, int des, int cost) {
        PriorityQueue<Country> pq = new PriorityQueue<>();
        pq.offer(new Country(v,cost));

        while(!pq.isEmpty()){
            Country cur = pq.poll();
            visited[cur.v] = true;
            if(cur.v==des){
                return cur.cost;
            }
            for(Country x : graph[cur.v]){
                if(!visited[x.v] && cur.cost+x.cost<dp[x.v]){
                    dp[x.v] = cur.cost+x.cost;
                    pq.offer(new Country(x.v,cur.cost+x.cost));
                }

            }
        }
        return cost;
    }
}

// 파티
import java.io.*;
import java.util.*;
class Go implements Comparable<Go>{
    public int v;
    public int time;

    public Go(int v, int time){
        this.v = v;
        this.time = time;
    }

    @Override
    public int compareTo(Go o){
        return this.time-o.time;
    }
}
public class Main {
    static int N,M,X;
    static int answer = Integer.MIN_VALUE;
    static ArrayList<Go> graph[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 학생 수
        M = Integer.parseInt(input[1]); // 도로 수
        X = Integer.parseInt(input[2]); // 파티 장소

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int time = Integer.parseInt(input[2]);
            graph[a].add(new Go(b,time));
        }

        for(int i=1;i<=N;i++){
            if(i==X) continue;
            int spendTime = 0;
            spendTime+=dijskra(i,X);
            spendTime+=dijskra(X,i);

            answer = Math.max(spendTime,answer);
        }

        System.out.println(answer);
    }

    public static int dijskra(int from, int to){
        boolean visited[] = new boolean[N+1];
        int dp[] = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        PriorityQueue<Go> pq = new PriorityQueue<>();

        pq.offer(new Go(from,0));
        dp[from] = 0;

        while(!pq.isEmpty()){
            Go cur = pq.poll();
            visited[cur.v] = true;
            if(cur.v==to) return dp[to];

            for(Go next : graph[cur.v]){
                if(!visited[next.v]){
                    if(dp[next.v]>dp[cur.v]+next.time){
                        dp[next.v] = dp[cur.v]+next.time;
                        pq.offer(new Go(next.v, dp[next.v]));
                    }
                }
            }
        }

        return dp[to];
    }
}

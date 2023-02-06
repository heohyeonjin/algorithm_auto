import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    public int v;
    public int w;

    public Node(int v, int w){
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o){
        if(this.w==o.w){
            return this.v-o.v;
        }
        return this.w-o.w;
    }
}
class Main{
    static ArrayList<Node> graph[];
    static boolean visited[];
    static int dp[];
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,E;
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            graph[a].add(new Node(b,w));
            graph[b].add(new Node(a,w));
        }

        dp = new int[N+1];
        visited = new boolean[N+1];
        input = br.readLine().split(" ");
        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);

        int path1 = 0;
        path1+=shortestDistance(1,v1);
        path1+=shortestDistance(v1,v2);
        path1+=shortestDistance(v2,N);

        int path2 = 0;
        path2+=shortestDistance(1,v2);
        path2+=shortestDistance(v2,v1);
        path2+=shortestDistance(v1,N);

        int answer = Math.min(path1,path2);
        if(answer>=INF){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }

    public static int distkra(int s, int d){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s,0));
        dp[s] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            visited[cur.v] = true;
            if(cur.v==d){
                return dp[d];
            }
            for(Node n : graph[cur.v]){
                if(!visited[n.v] && dp[n.v]>(cur.w+n.w)){
                    dp[n.v] = cur.w + n.w;
                    pq.offer(new Node(n.v,dp[n.v]));
                }
            }
        }
        return INF;
    }

    public static int shortestDistance(int from, int to){
        Arrays.fill(visited,false);
        Arrays.fill(dp,INF);
        return distkra(from,to);
    }
}
import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    public int v;
    public int cost;
    public Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o){
        return this.cost-o.cost;
    }

}
class Main{
    static ArrayList<int[]> graph[];
    static int V;
    static int S;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        V = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);
        S = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            graph[u].add(new int[]{v,cost});
        }

        int answer[] = dijstkra(graph);
        for(int i=1;i<=V;i++){
            if(answer[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(answer[i]);
        }
    }

    public static int[] dijstkra(ArrayList<int[]> graph[]){
        int dp[] = new int[V+1];
        for(int i=1;i<=V;i++)dp[i] = Integer.MAX_VALUE;
        dp[S] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(S,0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int v = node.v; // v 노드까지의
            int cost = node.cost; // 최소 비용

            if(dp[v]<cost) continue;

            for(int x[] : graph[v]){ // v 노드에서 뻗어나가기
                if(dp[x[0]]>cost+x[1]){
                    dp[x[0]] = cost+x[1];
                    queue.add(new Node(x[0],dp[x[0]]));
                }
            }
        }
        return dp;
    }
}
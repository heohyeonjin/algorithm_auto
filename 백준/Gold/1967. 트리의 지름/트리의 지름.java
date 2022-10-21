import java.io.*;
import java.util.*;

class Edge{
    public int node;
    public int cost;
    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}
class Main{
    static int n;
    static List<Edge> graph[];
    static int sum;
    static int maxLeaf;
    static int max=-1;
    static ArrayList<Integer> leaf;
    static boolean visited[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<n-1;i++){
            String str[] = br.readLine().split(" ");
            int v1 = Integer.parseInt(str[0]);
            int v2 = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            graph[v1].add(new Edge(v2,cost));
            graph[v2].add(new Edge(v1,cost));
        }

        visited = new boolean[n+1];
        dfs(1,0); // 가장 긴 leaf노드 인덱스 구하기
        visited = new boolean[n+1];
        dfs(maxLeaf,0); // maxLeaf를 루트로 지정하고 가장 긴 leaf 찾기
        System.out.println(max);

    }
    public static void dfs(int v,int sum) {
        visited[v] = true;
        if(max<sum){ // leaf 노드에 도착했을 때
            max = sum;
            maxLeaf = v;
        }
        for (Edge x : graph[v]) {
            if (!visited[x.node]) {
                dfs(x.node, sum + x.cost);
            }
        }
    }
}
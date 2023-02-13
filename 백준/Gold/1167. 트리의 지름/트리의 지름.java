import java.util.*;
import java.io.*;

// 트리의 지름
class Node{
    public int v;
    public int dis;

    public Node(int v, int dis){
        this.v = v;
        this.dis = dis;
    }
}
public class Main {
    static ArrayList<Node> graph[];
    static boolean visited[];
    static int answer = Integer.MIN_VALUE;
    static int farV;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int to = Integer.parseInt(st.nextToken());
                if(to==-1) break;
                int dis = Integer.parseInt(st.nextToken());
                graph[from].add(new Node(to,dis));
            }
        }

        visited = new boolean[N+1];
        visited[1] = true;
        DFS(1,0);
        visited = new boolean[N+1];
        visited[farV] = true;
        DFS(farV,0);
        System.out.println(answer);
    }

    public static void DFS(int v, int dis){
        for(Node n : graph[v]){
            if(!visited[n.v]){
                visited[n.v] = true;
                DFS(n.v,dis+n.dis);
                visited[n.v] = false;
            }
        }
        if(dis>answer){
            answer = dis;
            farV = v;
        }
    }
}

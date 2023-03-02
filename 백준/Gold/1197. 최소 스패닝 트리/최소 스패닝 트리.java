import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    public int A;
    public int B;
    public int C;

    public Node(int A, int B, int C){
        this.A = A;
        this.B = B;
        this.C = C;
    }
    @Override
    public int compareTo(Node o){
        return this.C-o.C;
    }
}
public class Main {
    static ArrayList<Node> line;
    static int weight;
    static int parent[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        line = new ArrayList<>();
        for(int i=0;i<E;i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            if(a<b){
                line.add(new Node(a,b,c));
            }
            else {
                line.add(new Node(b, a, c));
            }
        }

        Collections.sort(line); // 가중치의 합 최소
        parent = new int[V+1];
        Kruskal(V);
        System.out.println(weight);
    }
    public static void Kruskal(int V){
        for(int i=1;i<=V;i++){
            parent[i] = i;
        }

        int total_line = 0;
        for(Node n : line){
            if(total_line==V-1) break; // V-1개의 간선

            int a = find(n.A);
            int b = find(n.B);

            if(a!=b){ // 사이클이 아니면
                parent[a]=b;
                weight+=n.C;
                total_line++;
            }
        }
    }
    public static int find(int v){
        if(v==parent[v]) return v;
        return parent[v] = find(parent[v]);
    }
}

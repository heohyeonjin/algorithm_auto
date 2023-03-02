import java.util.*;
import java.io.*;
// 도시 분할 계획
class Node implements Comparable<Node>{
    public int a;
    public int b;
    public int c;

    public Node(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Node o){
        return this.c-o.c;
    }
}
public class Main {
    static ArrayList<Node> line;
    static int parent[];
    static int weight;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        line = new ArrayList<>();
        for(int i=0;i<M;i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            if(a<b){
                line.add(new Node(a,b,c));
            }
            else{
                line.add(new Node(b,a,c));
            }
        }
        Collections.sort(line);
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }
        kruskal(N);
        System.out.println(weight);
    }
    public static void kruskal(int N){
        int maxLine = Integer.MIN_VALUE;
        int totalLine = 0;
        for(Node n : line){
            if(totalLine==N-1) break;

            int a = find(n.a);
            int b = find(n.b);
            if(a!=b){
                totalLine++;
                parent[a] = b;
                weight+=n.c;
                maxLine = Math.max(maxLine,n.c);
            }
        }

        weight-=maxLine;
    }

    public static int find(int v){
        if(v==parent[v]){
            return v;
        }
        return parent[v] = find(parent[v]);
    }
}

import java.util.*;
import java.io.*;
class Data implements Comparable<Data>{
    public int v;
    public int cost;

    public Data(int v, int cost){
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Data o){
        if(this.cost==o.cost){
            return this.v-o.v;
        }
        else{
            return this.cost-o.cost;
        }
    }
}

public class Main {
    static ArrayList<Data> [] graph;
    static boolean visited[];
    static int minArray[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int answer[][] = new int[n][n];
        graph = new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            String input[] = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            graph[from].add(new Data(to,cost));
        }

        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            minArray = new int[n+1];
            Arrays.fill(minArray,Integer.MAX_VALUE);

            dijskra(i);

            for(int j=1;j<=n;j++){
                if(minArray[j]==Integer.MAX_VALUE){
                   answer[i-1][j-1] = 0;
                }
                else{
                    answer[i-1][j-1] = minArray[j];
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void dijskra(int from){
        PriorityQueue<Data> pq = new PriorityQueue<>();

        minArray[from] = 0;
        pq.offer(new Data(from,0));

        while(!pq.isEmpty()){
            Data cur = pq.poll();
            visited[cur.v] = true;

            for(Data next : graph[cur.v]){
                if(!visited[next.v]){
                    if(minArray[next.v]>minArray[cur.v]+next.cost){
                        minArray[next.v] = minArray[cur.v]+next.cost;
                        pq.offer(new Data(next.v,minArray[next.v]));
                    }
                }
            }
        }

    }
}

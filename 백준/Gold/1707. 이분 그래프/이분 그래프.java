import java.io.*;
import java.util.*;

// 이분 그래프
// 그래프 여러 개의 집합인 경우
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String input[] = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            ArrayList<Integer>[]graph = makeGraph(V,E);
            System.out.println(bfs(graph,V));
        }
    }
    public static ArrayList<Integer>[] makeGraph(int V, int E) throws IOException{
        ArrayList<Integer> graph[] = new ArrayList[V+1];
        for(int i=0;i<=V;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a].add(b);
            graph[b].add(a);
        }
        return graph;
    }
    public static String bfs(ArrayList<Integer>[]graph, int V){
        String answer = "YES";

        int group[] = new int[V+1];
        boolean visited[] = new boolean[V+1];

        Queue<int[]> queue = new LinkedList<>();

        for(int i=1;i<=V;i++){
            queue.add(new int[]{i,0});
            while(!queue.isEmpty()){
                int tmp[] = queue.poll();
                int v_num = tmp[0];
                int v_group = tmp[1];

                for(Integer x : graph[v_num]){
                    if(!visited[x]){
                        visited[x] = true;
                        if(v_group==0){
                            queue.add(new int[]{x,1});
                            group[x] = 1;
                        }
                        else if(v_group==1){
                            queue.add(new int[]{x,2});
                            group[x] = 2;
                        }
                        else{
                            queue.add(new int[]{x,1});
                            group[x] = 1;
                        }
                    }
                    if(group[x]==v_group){
                        answer = "NO";
                        break;
                    }

                }
            }

        }


        return answer;
    }
}

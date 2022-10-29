import java.util.*;
import java.io.*;
class Main{
    static int N,M;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        ArrayList<Integer> graph[] = new ArrayList[N+1]; // 연결 정보
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        int entry[] = new int[N+1]; // 선행하는 노드 개수 정보

        // 초기화
        for(int i=0;i<M;i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a].add(b);
            entry[b]++;
        }

        TopologySort(graph,entry);
        for(Integer x : answer){
            System.out.print(x+" ");
        }
    }

    public static void TopologySort(ArrayList<Integer> graph[], int entry[]){
        Queue<Integer> queue = new LinkedList<>(); // 진입 노드가 없는 노드 (가장 빠른 노드)

        // 큐 초기화
        for(int i=1;i<=N;i++){
            if(entry[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int result = queue.poll();
            answer.add(result);

            for(Integer x : graph[result]){ // result와 연결된 모든 노드들
                entry[x]--;
                if(entry[x]==0){
                    queue.offer(x);
                }
            }
        }
    }
}
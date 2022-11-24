import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static boolean visited[] = new boolean[100001];
    static int parent[] = new int[100001];
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        for(int i=0;i<100001;i++){
            parent[i]=-1;
        }
        int minTime = BFS();
        System.out.println(minTime-1);
        for(int i=answer.size()-1;i>=0;i--){
            System.out.print(answer.get(i)+" ");
        }
    }
    public static int BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;

        int phase = 0;
        boolean flag = false;
        while(!queue.isEmpty()){
            if(flag) break;
            int queueLen = queue.size();
            for (int i = 0; i < queueLen; i++) {
                int cur = queue.poll();
                if (cur == K) {
                    flag = true;
                   answer = new ArrayList<>();
                   answer.add(K);
                   while(true){
                        if(parent[K]==-1) break;
                        answer.add(parent[K]);
                        K = parent[K];
                    }
                   break;
                }
                int n_x = 0;
                for (int j = 0; j < 3; j++) {
                    if (j == 0) n_x = cur - 1;
                    else if (j == 1) n_x = cur + 1;
                    else n_x = cur * 2;

                    if (n_x >= 0 && n_x <= 100000) {
                        if (!visited[n_x]) {
                            visited[n_x] = true;
                            queue.offer(n_x);
                            parent[n_x] = cur; // 17의 parent는 16
                        }
                    }
                }
            }
            phase++;
        }
        return phase;
    }
}

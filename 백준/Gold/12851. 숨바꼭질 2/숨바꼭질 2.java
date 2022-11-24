import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int minTime;
    static int minCount;
    static int dir_x[] = {-1, 1};
    static int visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        visited = new int[100001];
        BFS();
        System.out.println(minTime);
        System.out.println(minCount);
    }

    public static void BFS() {
        int phase = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});
        visited[N] = 1;
        boolean flag = false;

        while (true) {
            if (flag) break;
            int queueLen = queue.size();
            for (int i = 0; i < queueLen; i++) {
                int subin[] = queue.poll();
                if (subin[0] == K) {
                    minTime = phase;
                    minCount++;
                    flag = true;
                }
                for (int j = 0; j < 2; j++) {
                    int n_x = subin[0] + dir_x[j];
                    if (n_x >= 0 && n_x <= 100000) {
                        if (visited[n_x]==0 || visited[n_x]==subin[1]+1) {
                            visited[n_x] = subin[1]+1;
                            queue.offer(new int[]{n_x, subin[1] + 1});
                        }
                    }
                }
                int n_x = subin[0] * 2;
                if (n_x >= 0 && n_x <= 100000) {
                        if(visited[n_x]==0 || visited[n_x]==subin[1]+1){
                            visited[n_x] = subin[1]+1;
                            queue.offer(new int[]{n_x, subin[1] + 1});
                        }
                    }
                }
            phase++;

            }

        }
}

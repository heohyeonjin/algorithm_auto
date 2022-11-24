import java.util.*;
import java.io.*;
class Subin implements Comparable<Subin>{
    public int X;
    public int count;
    public Subin(int X, int count){
        this.X = X;
        this.count = count;
    }

    @Override
    public int compareTo(Subin o){
        return this.count-o.count;
    }
}
public class Main {
    static int N,K;
    static int time[] = new int[100001];
    static int dir_x[] = {-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        int answer = BFS();
        System.out.println(answer);
    }
    public static int BFS(){
        int answer = Integer.MAX_VALUE;
        Queue<Subin> queue = new LinkedList<>();
        queue.offer(new Subin(N,0));
        boolean flag = false;
        while(!queue.isEmpty()){
            if(flag) break;
            int queueLen = queue.size();
//            Queue<Subin> tmpQueue = new LinkedList<>();
            for(int i=0; i<queueLen; i++){
                Subin cur = queue.poll();
                if(cur.X == K) {
                    answer = Math.min(answer,cur.count);
                    flag = true;
                }
                for(int j=0;j<2;j++){
                    int n_x = cur.X+dir_x[j];
                    if(n_x>=0 && n_x<=100000){
                        if(time[n_x]==0 || time[n_x] > cur.count+1){
                            queue.offer(new Subin(n_x,cur.count+1));
                            time[n_x] = cur.count+1;
                        }
                    }
                }
                int n_x = cur.X*2;
                if(n_x>=0 && n_x<=100000 && cur.X!=0){
                    if(time[n_x]==0 || time[n_x] > cur.count){
                        queue.offer(new Subin(n_x,cur.count));
                        time[n_x] = cur.count;
                    }
                }
            }

//            for(Subin tmp : tmpQueue){
//                queue.offer(tmp);
//            }

//            for(Subin x : queue){
//                System.out.print(x.X +","+x.count+" ");
//            }
//            System.out.println();
        }
        return answer;
    }
}

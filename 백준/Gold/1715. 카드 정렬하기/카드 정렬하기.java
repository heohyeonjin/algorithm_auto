import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            pqueue.offer(Integer.parseInt(br.readLine()));
        }
        int answer = Greedy(pqueue);
        System.out.println(answer);
    }
    public static int Greedy(PriorityQueue<Integer> pqueue){
       int sum = 0;
        while(pqueue.size()>1){
            int a = pqueue.poll();
            int b = pqueue.poll();
            sum += a+b;
            pqueue.offer(a+b);
        }
        return sum;
    }
}
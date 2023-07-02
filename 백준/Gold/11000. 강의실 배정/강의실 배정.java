import java.util.*;
import java.io.*;
class Room implements Comparable<Room>{
    public int start;
    public int end;

    public Room(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room o){
        if(this.start == o.start){
            return this.end-o.end;
        }
      return this.start-o.start;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Room room[] = new Room[N];
        for(int i=0;i<N;i++){
            String input[] = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            room[i] = new Room(start,end);
        }

        Arrays.sort(room);

        pq.offer(room[0].end);
        for(int i=1;i<N;i++){
            if(room[i].start>=pq.peek()){
                pq.poll();
            }
            pq.offer(room[i].end);
        }

        System.out.println(pq.size());

    }
}

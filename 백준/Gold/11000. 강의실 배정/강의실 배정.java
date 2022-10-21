// 강의실 배정
import java.io.*;
import java.util.*;
class Lecture implements Comparable<Lecture>{
    public int start;
    public int end;
    public Lecture(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
       if(this.start==o.start){
           return this.end-o.end;
       }
        return this.start-o.start;
    }
}

class Main{
    static int N;
    static PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();
    static int answer;
    static Lecture lecture[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lecture= new Lecture[N];
        for(int i=0;i<N;i++){
            String str[] = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            lecture[i] = new Lecture(start,end);
        }
        Arrays.sort(lecture); // 시작 시각 기준 오름차순 정렬
        // 시작 시각 빠른 순으로 검사하고 끝나는 시각을 queue에 넣어서
        // queue에 저장된 끝나는 시각들 중 가장 빠른 것과 비교(priority queue)
        Solution();
        System.out.println(pqueue.size());
    }
    public static void Solution(){
        pqueue.offer(lecture[0].end); // 끝나는 시각 queue에 저장
        for(int i=1;i<N;i++){
            if(pqueue.peek()<=lecture[i].start)
               pqueue.poll();
            pqueue.offer(lecture[i].end);
        }
    }
}
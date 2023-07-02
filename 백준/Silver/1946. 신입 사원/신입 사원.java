import java.awt.print.Paper;
import java.util.*;
import java.io.*;
class Person implements Comparable<Person>{
    public int paper;
    public int inteview;

    public Person(int paper, int inteview){
        this.paper = paper;
        this.inteview = inteview;
    }

    @Override
    public int compareTo(Person o){
        if(this.paper == o.paper){
            return this.inteview-o.inteview;
        }
        return this.paper-o.paper;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer[] = new int[T];


        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Person> pq = new PriorityQueue<>();

            for(int j=0;j<N;j++){
                String input[] = br.readLine().split(" ");
                int paper = Integer.parseInt(input[0]);
                int interview = Integer.parseInt(input[1]);
                pq.offer(new Person(paper,interview));
            }

            int count = 1;
            int prev_interview = pq.poll().inteview;
            while(!pq.isEmpty()){
                Person cur = pq.poll();
                if(cur.inteview==1){
                    count++;
                    break;
                }

                if(cur.inteview<prev_interview){
                    prev_interview = cur.inteview;
                    count++;
                }
            }

            answer[i] = count;
        }
        for(int i=0;i<T;i++){
            System.out.println(answer[i]);
        }
    }
}


import java.util.*;
import java.io.*;
public class Main {
    static int N,S;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int sequence[] = new int[N];
        for(int i=0;i<N;i++){
            sequence[i] = Integer.parseInt(input[i]);
        }

        TwoPoint(0,0,sequence);
        System.out.println(answer);
    }
    public static void TwoPoint(int left, int right, int sequence[]){
        int sum = sequence[0];
        while(true){
            if(sum<S){
                right++;
                if(right>=N) break;
                sum+=sequence[right];
            }
            else{
//                System.out.println(left+","+right);
                answer = Math.min(answer,right-left+1);
                sum-=sequence[left];
                left++;
            }
        }
        if(answer==Integer.MAX_VALUE) answer = 0;
    }

}

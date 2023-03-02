import java.util.*;
import java.io.*;
//다각형의 넓이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long x[] = new long[N+1];
        long y[] = new long[N+1];

        for(int i=0;i<N;i++){
            String input[] = br.readLine().split(" ");
            x[i] = Long.parseLong(input[0]);
            y[i] = Long.parseLong(input[1]);
        }
        x[N] = x[0];
        y[N] = y[0];
        long sum = 0;
        for(int i=0;i<N;i++){
            sum+=x[i]*y[i+1];
        }

        for(int i=1;i<=N;i++){
            sum-=y[i-1]*x[i];
        }

        sum = Math.abs(sum);
        String answer = String.format("%.1f",sum/2.0);
        System.out.println(answer);
    }
}

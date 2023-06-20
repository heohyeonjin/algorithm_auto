import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        long T[] = new long[N];
        for(int i=0;i<N;i++){
            T[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(T);

        long answer = binarySearch(1,T[0]*M,T,M);
        System.out.println(answer);
    }
    public static long binarySearch(long left, long right, long T[], int M){
        long result = Long.MAX_VALUE;

        while(left<=right){
            long sum = 0;
            long mid = (left+right)/2;

            for(long x : T){
                sum+=mid/x;
            }

            if(sum>=M){
                result = Math.min(result, mid);
                right = mid-1;
            }

            else{
                left = mid+1;
            }
        }
        return result;
    }
}

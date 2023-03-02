import java.util.*;
import java.io.*;
// 용액
public class Main {
    static int a,b;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int solution[] = new int[N];
        String input[] = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            solution[i] = Integer.parseInt(input[i]);
        }
        BinarySearch(solution,N);
        System.out.println(a+" "+b);
    }
    public static void BinarySearch(int []solution, int N){
        int value = Integer.MAX_VALUE;
        int left = 0;
        int right = N-1;
        while(left<right){
            int sum = solution[left]+solution[right];
            if(Math.abs(sum)<=value){
                value = Math.abs(sum);
                a = solution[left];
                b = solution[right];
            }

            if(sum<0){
                left++;
            }
            else if(sum>0){
                right--;
            }
            else{
                break;
            }
        }
    }

}

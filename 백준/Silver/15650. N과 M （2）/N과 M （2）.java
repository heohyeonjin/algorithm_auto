import java.util.*;
import java.io.*;
public class Main {
    static boolean visited[];
    static int comb[];
    static int arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=1;i<=N;i++){
            arr[i-1] = i;
        }

        comb = new int[M];
        Combi(0,0,N,M);
    }
    public static void Combi(int depth,int start, int n, int r){
        if(depth==r){
            for(int i=0;i<comb.length;i++){
                System.out.print(comb[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<n; i++){
            comb[depth] = arr[i];
            Combi(depth+1, i+1,n,r);
        }
    }
}

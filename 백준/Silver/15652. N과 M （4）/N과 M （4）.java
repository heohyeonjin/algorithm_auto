import java.util.*;
import java.io.*;
public class Main {
    static int comb[];
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        comb = new int[M];

        arr = new int[N];
        for(int i=1;i<=N;i++){
            arr[i-1] = i;
        }

        Combi(N,M,0,0);

    }
    public static void Combi(int n, int r, int depth, int start){
        if(depth==r){
            for(int i=0;i<comb.length;i++){
                System.out.print(comb[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<n; i++){
            comb[depth] = arr[i];
            Combi(n,r,depth+1,i);
        }
    }
}

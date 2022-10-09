import java.util.*;
import java.io.*;
class Main{
    static int N,M;
    static int parent[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        boolean visited[][] = new boolean[N+1][N+1];
        //연결
        parent = new int[N+1];
        for(int i=0;i<N+1;i++){
            parent[i] = i;
        }

        String input[];
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                int link = Integer.parseInt(input[j]);
                if(link==1){
                    if(!visited[i+1][j+1]){
                        union(i+1,j+1);
                        visited[i+1][j+1] = true;
                        visited[j+1][i+1] = true;
                    }

                }
            }
        }
        input = br.readLine().split(" ");

       if(check(parent,input)) System.out.println("YES");
       else System.out.println("NO");

    }
    public static boolean check(int parent[],String input[]){
        int start_idx = Integer.parseInt(input[0]);
        int start_value = find(parent[start_idx]);

        for(int i=1;i<M;i++){
            int value = Integer.parseInt(input[i]);
            if(start_value!=find(value)) return false;
        }
        return true;
    }
    public static int find(int x){
        if(x==parent[x]) return x;
        else return find(parent[x]);

    }
    public static void union(int i, int j){
        int a = find(i);
        int b = find(j);

        parent[a] = b;
    }
}
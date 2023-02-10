// 집합의 표현
import java.util.*;
import java.io.*;
class Main{
    static int N,M;
    static int parent[];
    static int root[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        root = new int[N+1];

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int p1 = find(a);
            int p2 = find(b);

            if(num==0){ // 합치기
                if (p1 != p2) {
                    union(p1,p2);
                }
            }
            else{ // 확인
                if(p1 == p2){
                    sb.append("YES"+"\n");
                }
                else{
                    sb.append("NO"+"\n");
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static int find(int idx){
        if(idx==parent[idx])
            return idx;
        else return find(parent[idx]);
    }

    public static void union(int a, int b){
       parent[b] = a;
    }
}
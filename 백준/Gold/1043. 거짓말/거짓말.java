import java.io.*;
import java.util.*;
// 거짓말
public class Main {
    static int N,M;
    static boolean knowTrue[];
    static int parent[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        knowTrue = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        int know_num = Integer.parseInt(st.nextToken());
        for(int i=0;i<know_num;i++){
            int who = Integer.parseInt(st.nextToken());
            knowTrue[who] = true;
        }

        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        // 연결
        HashSet<Integer>[] visitParty = new HashSet[M+1];
        for(int i=1;i<=M;i++){
            visitParty[i] = new HashSet<>();
        }

        for(int i=1;i<=M;i++){
            String input[] = br.readLine().split(" ");
            int party_num = Integer.parseInt(input[0]);

            if(party_num==1){
                visitParty[i].add(Integer.parseInt(input[1]));
                continue;
            }

            for(int j=1;j<party_num;j++){
                int a = find(Integer.parseInt(input[j]));
                int b = find(Integer.parseInt(input[j+1]));
                if(a!=b){
                    union(a,b);
                }
                visitParty[i].add(a);
                visitParty[i].add(b);
            }
        }

        // 연관관계 있으면 knowTrue = true
        boolean visited[] = new boolean[N+1];
        for(int i=1;i<=N;i++){
            if(knowTrue[i] && !visited[i]){
                int root = find(i);
                for(int j=1;j<=N;j++){
                    if(find(j)==root){
                        knowTrue[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        int result = 0;
        for(int i=1;i<=M;i++){
            boolean flag = false;
            for(int person : visitParty[i]){
                if(knowTrue[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        System.out.println(result);

    }

    public static int find(int idx){
        if(idx==parent[idx]) return idx;
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public static void union(int a, int b){
        int parent_b = find(b);
        parent[parent_b] = a;
    }
}

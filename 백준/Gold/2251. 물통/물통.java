// 물통
import java.io.*;
import java.util.*;
public class Main {
    static int limit[];
    static boolean checked[][];
    static TreeSet<Integer> answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        limit = new int[3];
        for(int i=0;i<3;i++){
            limit[i] = Integer.parseInt(input[i]);
        }

        checked = new boolean[201][201];
        answer = new TreeSet<>();
        dfs(0,0,limit[2]);

        for(Integer x : answer){
            System.out.print(x+" ");
        }
    }

    public static void dfs(int a, int b, int c){
      
        if(checked[a][b]) return; // 종료 조건

        if(a==0){
            answer.add(c);
        }

        checked[a][b] = true;

        //0->1
        if(a+b<=limit[1]){
            dfs(0,a+b,c);
        }
        else{
            dfs(a-(limit[1]-b),limit[1],c);
        }
        //1->0
        if(a+b<=limit[0]){
            dfs(a+b,0,c);
        }
        else{
            dfs(limit[0],b-(limit[0]-a),c);
        }

        // 0->2
        if(a+c<=limit[2]){
            dfs(0,b,a+c);
        }
        else{
            dfs(a-(limit[2]-c),b,limit[2]);
        }
        // 2->0
        if(a+c<=limit[0]){
            dfs(a+c,b,0);
        }
        else{
            dfs(limit[0],b,c-(limit[0]-a));
        }

        //1->2
        if(b+c<=limit[2]){
          dfs(a,0,b+c);
        }
        else{
            dfs(a,b-(limit[2]-c),limit[2]);
        }
        //2->1
        if(b+c<=limit[1]){
            dfs(a,b+c,0);
        }
        else{
            dfs(a,limit[1],c-(limit[1]-b));
        }

    }
}

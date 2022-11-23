
import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int board[][];
    static boolean visited[][];
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new int[N][M];
        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            for(int j=0;j<tmp.length();j++){
                board[i][j] = Integer.parseInt(tmp.charAt(j)+"");
            }
        }
        visited = new boolean[N][M];
        int answer = BFS();
        System.out.println(answer+1);
    }
    public static int BFS(){
        int result = 0;
        Queue<int[]> queue = new LinkedList<>(); // x좌표,y좌표,개수
        queue.offer(new int[]{0,0,0});
        visited[0][0] = true;
        while(!queue.isEmpty()){
           int[] cur = queue.poll();
           if(cur[0]==N-1 && cur[1]==M-1){
               result = cur[2];
           }
           for(int i=0;i<4;i++){
               int n_row = cur[0]+dir_row[i];
               int n_col = cur[1]+dir_col[i];
               int n_num = cur[2]+1;

               if(n_row>=0 && n_col>=00 && n_row<N && n_col<M){
                   if(board[n_row][n_col]==1){
                       if(!visited[n_row][n_col]){
                           visited[n_row][n_col] = true;
                           queue.offer(new int[]{n_row,n_col,n_num});
                       }
                   }
               }
           }
        }
        return result;
    }
}

import java.util.*;
import java.io.*;
public class Main {
    static int M,N;
    static boolean visited[][];
    static int board[][];
    static Queue<int[]> queue = new LinkedList<>();
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String input[] = br.readLine().split(" ");
       M = Integer.parseInt(input[0]);
       N = Integer.parseInt(input[1]);
       board = new int[N][M];
       visited = new boolean[N][M];
       int ripenCnt = 0;
       int tomaCnt = 0;
       for(int i=0;i<N;i++){
           input = br.readLine().split(" ");
           for(int j=0;j<M;j++){
               board[i][j] = Integer.parseInt(input[j]);
               if(board[i][j]!=-1) tomaCnt++;
               if(board[i][j]==1){
                   ripenCnt++;
                   queue.offer(new int[]{i,j});
                   visited[i][j] = true;
               }
           }
        }
        int answer = BFS(ripenCnt, tomaCnt);
        System.out.println(answer);
    }
    public static int BFS(int ripenCnt, int tomaCnt){
        int phase = 0;
        boolean flag = false;
        while(!queue.isEmpty()){
            int queueLen = queue.size();
            if(ripenCnt==tomaCnt){
                flag = true;
                break;
            }
            for(int i=0; i<queueLen; i++){
                int cur[] = queue.poll();
                for(int j=0;j<4;j++){
                    int n_row = cur[0]+dir_row[j];
                    int n_col = cur[1]+dir_col[j];
                    if(n_row>=0 && n_col>=0 && n_row<N && n_col<M){
                        if(!visited[n_row][n_col] && board[n_row][n_col]!=-1){
                            visited[n_row][n_col] = true;
                            queue.offer(new int[]{n_row,n_col});
                            ripenCnt++;
                        }
                    }
                }
            }
            phase++;
        }
        if(flag) return phase;
        else return -1;
    }
}

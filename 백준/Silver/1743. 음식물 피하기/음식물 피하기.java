
import java.util.*;
import java.io.*;
public class Main {
    static int N,M,K;
    static char board[][];
    static boolean visited[][];
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        board = new char[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(board[i],'.');
        }
        for(int i=0;i<K;i++){
            input = br.readLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            board[row-1][col-1] = '#';
        }


        int answer = Integer.MIN_VALUE;
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int k=0;k<N;k++){
                    Arrays.fill(visited[i],false);
                }
                int result = BFS(i,j);
                answer = Math.max(answer,result);
            }
        }
        System.out.println(answer);
    }
    public static int BFS(int row, int col){
        if(board[row][col]=='.') return 0;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            count++;
            for(int i=0;i<4;i++){
                int n_row = cur[0] + dir_row[i];
                int n_col = cur[1] + dir_col[i];
                if(n_row>=0 && n_col>=0 && n_row<N && n_col<M){
                    if(board[n_row][n_col]=='#' && !visited[n_row][n_col]){
                        visited[n_row][n_col] = true;
                        queue.offer(new int[]{n_row,n_col});
                    }
                }
            }
        }
        return count;
    }

}

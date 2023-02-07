import java.util.*;
import java.io.*;
class Wall implements Comparable<Wall>{
    public Pos pos;
    public int breakNum;

    public Wall(Pos pos, int breakNum){
        this.pos = pos;
        this.breakNum = breakNum;
    }

    @Override
    public int compareTo(Wall o){
        return this.breakNum-o.breakNum;
    }
}
class Pos{
    public int row;
    public int col;
    public Pos(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class Main {
    static int M,N;
    static boolean visited[][];
    static char miro[][];
    static int dp[][];
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        miro = new char[N][M];
        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            for(int j=0;j<M;j++){
                miro[i][j] = tmp.charAt(j);
            }
        }

        dp = new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        visited = new boolean[N][M];
        DFS(0,0);
//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[N-1][M-1]);
    }
    public static void DFS(int row, int col){
        PriorityQueue<Wall> pq = new PriorityQueue<>();
        pq.offer(new Wall(new Pos(row,col),0));
        dp[0][0] = 0;

        while(!pq.isEmpty()){
            Wall cur = pq.poll();
            Pos p = cur.pos;
            visited[p.row][p.col] = true;
            for(int i=0;i<4;i++){
                int n_row = p.row+dir_row[i];
                int n_col = p.col+dir_col[i];

                if(n_row>=0 && n_col>=0 && n_row<N && n_col<M){
                    if(!visited[n_row][n_col]){
                        if(miro[n_row][n_col]=='1'){ // 벽이면
                            if(dp[n_row][n_col]>dp[p.row][p.col]+1){
                                dp[n_row][n_col] = dp[p.row][p.col]+1;
                                pq.offer(new Wall(new Pos(n_row,n_col),dp[n_row][n_col]));
                            }

                        }
                        else{
                            dp[n_row][n_col] = dp[p.row][p.col];
                            pq.offer(new Wall(new Pos(n_row,n_col),cur.breakNum));
                        }
                    }
                }
            }
        }
    }
}

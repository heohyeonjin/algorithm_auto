import java.io.*;
import java.util.*;
class ICE{
    public int row;
    public int col;
    public int height;

    public ICE(int row, int col, int height){
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
public class Main {
    static int N,M;
    static int answer = 0;
    static int ice[][];
    static Queue<ICE> queue;
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};
    static boolean isvisited[][];
    static int iceNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        ice = new int[N][M];
        queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                ice[i][j] = Integer.parseInt(input[j]);
                if(ice[i][j]>0){
                    queue.offer(new ICE(i,j,ice[i][j]));
                }
            }
        }

        while(true){
            // 멜팅
            melt();

            // 빙하가 다 녹으면
            if(queue.size()==0){
                answer = 0;
                break;
            }

            // 분리 여부 확인
            isvisited = new boolean[N][M];
            iceNum = 1;
            DFS(queue.peek());
            if(queue.size()!=iceNum){ // 덩어리로 분리됨
                answer++;
                break;
            }
            else{
                answer++;
            }
        }

        System.out.println(answer);

    }
    public static void melt(){
        int queueSize = queue.size();
        for(int l=0; l<queueSize; l++){
            ICE cur = queue.poll();
            int surround = 0;
            for(int i=0;i<4;i++){
                int n_row = cur.row+dir_row[i];
                int n_col = cur.col+dir_col[i];
                if(n_row>=0 && n_row<N && n_col>=0 &&n_col<M){
                    if(ice[n_row][n_col]==0){
                        surround++;
                    }
                }
            }
            int n_height = ice[cur.row][cur.col]-surround;
            if(n_height>0){
                queue.offer(new ICE(cur.row,cur.col,n_height));
            }
        }

        ice = new int[N][M];
        for(ICE cur : queue){
            ice[cur.row][cur.col] = cur.height;
        }
    }
    public static void DFS(ICE cur){
        isvisited[cur.row][cur.col] = true;
        for(int i=0;i<4;i++){
            int n_row = cur.row+dir_row[i];
            int n_col = cur.col+dir_col[i];

            if(!isvisited[n_row][n_col] && n_row>=0 && n_row<N && n_col>=0 && n_col<M){
                if(ice[n_row][n_col]>0){
                    iceNum++;
                    DFS(new ICE(n_row,n_col,ice[n_row][n_col]));
                }
            }
        }
    }
}

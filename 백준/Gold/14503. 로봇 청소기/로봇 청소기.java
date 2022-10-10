import java.util.*;
import java.io.*;
class Main{
    static int N,M;
    static int space[][];
    static int answer = 0;
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int robot_row = Integer.parseInt(input[0]);
        int robot_col = Integer.parseInt(input[1]);
        int robot_head = Integer.parseInt(input[2]);

        space = new int[N][M];
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                space[i][j] = Integer.parseInt(input[j]);
            }
        }
        answer++;
        dfs(robot_row,robot_col,robot_head);
        System.out.println(answer);
    }

    public static void dfs(int robot_row, int robot_col, int robot_head){

        space[robot_row][robot_col] = -1;

        for(int i=0;i<4;i++) {
            //반시계 회전
            robot_head = (robot_head+3)%4;

            //한 칸 전진 확인
            int n_row = robot_row + dir_row[robot_head];
            int n_col = robot_col + dir_col[robot_head];

            if(n_row<0||n_col<0||n_row>N-1||n_col>M-1) continue;

            if (space[n_row][n_col]==0) { // 청소하지 않은 공간이 존재한다면
                answer++;
                dfs(n_row, n_col, robot_head);
                return;
            }
        }

        // 네 방향 모두 청소
        int back = (robot_head+2) % 4; // 한 칸 후진
        int n_row = robot_row+dir_row[back];
        int n_col = robot_col+dir_col[back];

        if(n_row<0||n_col<0||n_row>N-1||n_col>M-1) return;

        if(space[n_row][n_col]!=1)
            dfs(n_row,n_col,robot_head);

    }
}
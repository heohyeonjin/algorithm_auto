

import java.io.*;
import java.util.*;

class Main{
    static int R,C;
    static boolean dochi_visited[][];
    static boolean water_visited[][];
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        char board[][] = new char[R][C];
        Queue<int[]> dochi = new LinkedList<>();
        Queue<int[]> water = new LinkedList<>();
        dochi_visited = new boolean[R][C];
        water_visited = new boolean[R][C];
        int biber_row=0,biber_col=0;
        for(int i=0;i<R;i++){
            String tmp = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = tmp.charAt(j);
                if(board[i][j]=='D'){
                    biber_row = i;
                    biber_col = j;
                }
                if(board[i][j]=='S'){
                    dochi_visited[i][j] = true;
                    dochi.add(new int[]{i,j});
                    board[i][j] ='.';
                }
                if(board[i][j]=='*'){
                    water_visited[i][j] = true;
                    water.add(new int[]{i,j});
                }
            }
        }
        int answer = BFS(board,dochi,water,biber_row,biber_col);
        if(answer==-1) System.out.println("KAKTUS");
        else System.out.println(answer);
    }
    public static int BFS(char board[][], Queue<int[]> dochi, Queue<int[]> water, int biber_row, int biber_col){
        int minute = 0;
        while(!dochi.isEmpty()){
            minute++;
            //물 뿌리기
            int water_len = water.size();
            for(int i=0;i<water_len;i++){
                int cur[] = water.poll();
                int cur_row = cur[0];
                int cur_col = cur[1];
                for(int j=0;j<4;j++){
                    int n_row = cur_row+dir_row[j];
                    int n_col = cur_col+dir_col[j];
                    if(n_row>=0 && n_row<R && n_col>=0 && n_col<C){
                        if(board[n_row][n_col]=='.' && !water_visited[n_row][n_col]){
                            water_visited[n_row][n_col] = true;
                            board[n_row][n_col] = '*';
                            water.add(new int[]{n_row,n_col});
                        }
                    }
                }
            }

            //도치 옮기기
            int dochi_len = dochi.size();
            for(int i=0; i<dochi_len; i++){
                int cur[] = dochi.poll();
                int cur_row = cur[0];
                int cur_col = cur[1];
                for(int j=0;j<4;j++){
                    int n_row = cur_row+dir_row[j];
                    int n_col = cur_col+dir_col[j];
                    if(n_row>=0 && n_row<R && n_col>=0 && n_col<C){
                        if(board[n_row][n_col]=='D') return minute;
                        if(board[n_row][n_col]=='.' && !dochi_visited[n_row][n_col]){
                            dochi_visited[n_row][n_col] = true;
                            dochi.add(new int[]{n_row,n_col});
                        }
                    }
                }

            }

        }
        return -1;
    }
}
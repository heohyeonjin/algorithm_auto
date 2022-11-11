
import java.util.*;
import java.io.*;
public class Main {
    static boolean visited[];
    static char board[][];
    static final int ALPHABET_NUM = 26;
    static int answer = Integer.MIN_VALUE;
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        board = new char[R][C];
        for(int i=0;i<R;i++){
            String tmp = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = tmp.charAt(j);
            }
        }

        visited = new boolean[ALPHABET_NUM];
        visited[board[0][0]-'A'] = true;
        dfs(1,R,C,0,0);
        System.out.println(answer);
    }

    public static void dfs(int count, int R, int C, int row, int col){
        int alphabetIndex = -1;
        boolean move = false;
        for(int i=0;i<4;i++){
            int n_row = row+dir_row[i];
            int n_col = col+dir_col[i];
            if(n_row>=0 && n_row<R && n_col>=0 && n_col<C){
                alphabetIndex = board[n_row][n_col]-'A';
                if(!visited[alphabetIndex]){
                    move = true;
                    visited[alphabetIndex] = true;
                    dfs(count+1,R,C,n_row,n_col);
                    visited[alphabetIndex] = false;
                }
            }
        }

        if(!move){ // 더 이상 갈 데가 없을 때 종료
           answer = Math.max(answer,count);
           return;
        }
    }


}

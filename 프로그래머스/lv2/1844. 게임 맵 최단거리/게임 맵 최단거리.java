import java.util.*;
class Position{
    public int row;
    public int col;
    public int cnt;
    public Position(int row, int col, int cnt){
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}
class Solution {
    static int[] dir_row={-1,0,1,0};
    static int[] dir_col={0,1,0,-1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        answer = solve(maps);
        return answer;
    }
    public static int solve(int [][] maps){
        int n = maps.length;
        int m = maps[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(n-1,m-1,1));
        visited[n-1][m-1] = true;
        Position cur = null;
        boolean flag = false;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur.row==0&&cur.col==0){
                flag = true;
                break;  
            } 
            for(int i=0;i<4;i++){
                int n_row = cur.row+dir_row[i];
                int n_col = cur.col+dir_col[i];
                int n_cnt = cur.cnt+1;
                if(n_row<0||n_row>n-1||n_col<0||n_col>m-1) continue; // 범위 밖
                if(maps[n_row][n_col]==0) continue; //벽
                if(visited[n_row][n_col]) continue; //방문 했을 경우
                queue.offer(new Position(n_row,n_col,n_cnt));
                visited[n_row][n_col] = true;
            }
        }
        
        if(!flag) return -1;
        return cur.cnt;
        
    }
}
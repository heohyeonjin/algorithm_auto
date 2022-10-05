import java.util.*;
class Solution {
    static boolean visited[];
    static int answer = 0;
    static boolean flag;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            flag = false;
            dfs(i,computers,n);
            if(flag) answer++;
        }
        return answer;
    }
    public static void dfs(int row, int[][] computers,int n){
        if(visited[row]) return;
        visited[row] = true;
        flag = true;
        for(int i=0;i<n;i++){
            if(row==i) continue;
            if(computers[row][i]==1) dfs(i,computers,n);
        }
    }
}
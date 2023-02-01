import java.io.*;
import java.util.*;
//적록색약
public class Main {
    static char[][] arr;
    static boolean[][] visited;
    static int dir_row[] = {-1,0,1,0};
    static int dir_col[] = {0,1,0,-1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = input.charAt(j);
            }
        }

        visited = new boolean[N][N];
        int a = BFS(false); // 적록 색약X

        visited = new boolean[N][N];
        int b = BFS(true); // 적록 색약

        System.out.println(a+" "+b);
    }

    public static int BFS(boolean RG){
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]) continue;
                else{
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int tmp[] = queue.poll();
                        for(int k=0;k<4;k++){
                            int n_row = tmp[0]+dir_row[k];
                            int n_col = tmp[1]+dir_col[k];
                            if(n_row>=0 && n_col>=0 && n_row<N & n_col<N){
                                if(!visited[n_row][n_col]){
                                    if(RG){ //적록 색약이면
                                        if(arr[tmp[0]][tmp[1]]==arr[n_row][n_col] || arr[tmp[0]][tmp[1]]+arr[n_row][n_col]==('R'+'G')){
                                            queue.offer(new int[]{n_row,n_col});
                                            visited[n_row][n_col] = true;
                                        }
                                    }
                                    else{
                                        if(arr[tmp[0]][tmp[1]]==arr[n_row][n_col]){
                                            queue.offer(new int[]{n_row,n_col});
                                            visited[n_row][n_col] = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;

    }
}

import java.util.*;
import java.io.*;
class fish_info_list{
    public int dir;
    public int row;
    public int col;

    public fish_info_list(int dir, int row, int col){
        this.dir = dir;
        this.row = row;
        this.col = col;
    }
}
class Fish{
    public int num;
    public int dir;
    public Fish(int num, int dir){
        this.num = num;
        this.dir = dir;
    }
}
class Main{
    static int dir_row[]= {-1,-1,0,1,1,1,0,-1};
    static int dir_col[]= {0,-1,-1,-1,0,1,1,1};
    static int answer = Integer.MIN_VALUE;
     public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         Fish space[][] = new Fish[4][4]; // 물고기 지도 정보
         HashMap<Integer,fish_info_list> fishes = new HashMap<>(); // 물고기 정보들

         for(int i=0;i<4;i++){
             String input[] = br.readLine().split(" ");
             for(int j=0;j<4;j++){
                 int fish_num = Integer.parseInt(input[j*2]);
                 int fish_dir = Integer.parseInt(input[j*2+1]);
                 space[i][j] = new Fish(fish_num, fish_dir-1); // 지도 맵 (물고기 번호, 방향)
                 fishes.put(fish_num,new fish_info_list(fish_dir-1,i,j)); // 물고기 번호 --> 물고기 방향, 위치
             }
         }

         int shark_row = 0;
         int shark_col = 0;
         int shark_dir = space[0][0].dir; // 상어 방향 초기화

         // (0,0)에 있는 물고기 먹음
         int fish_num = space[0][0].num;
         int sum = fish_num;
         fishes.remove(fish_num);

         dfs(sum,space,fishes,shark_row,shark_col,shark_dir);
         System.out.println(answer);
     }

     public static void dfs(int sum, Fish [][] space, HashMap<Integer,fish_info_list> fishes, int shark_row, int shark_col, int shark_dir){

         // 물고기 재배치(물고기 번호대로)
         int fish=1;
         while(true){
             if(fish>16) break;

             if(!fishes.containsKey(fish)){ //죽은 물고기
                 fish++; continue;
             }
             fish_info_list cur = fishes.get(fish); //물고기 한 마리씩 탐색
             int dir_idx = cur.dir; // 물고기 현재 방향
             for (int i = 0; i < 8; i++) { // 물고기 이동 탐색 (반시계)
                 int n_row = cur.row + dir_row[(dir_idx + i) % 8];
                 int n_col = cur.col + dir_col[(dir_idx + i) % 8];
                 if (n_row >= 0 && n_col >= 0 && n_col < 4 && n_row < 4) { // 범위 벗어나지 않으면
                     if (n_row != shark_row || n_col != shark_col) { // 상어가 아니면
                         if(space[n_row][n_col]==null){ // 빈칸이면 현재 것만 변경
                             space[n_row][n_col] = new Fish(space[cur.row][cur.col].num,(dir_idx+i)%8);
                             space[cur.row][cur.col]= null; // 현재 값 비우기
                             fishes.put(fish, new fish_info_list((dir_idx+i)%8, n_row,n_col)); // 바뀐 방향 저장
                         }
                         else { // 물고기 swap
                             // 해쉬맵 정보 변경
                             fishes.put(fish, new fish_info_list((dir_idx + i) % 8, n_row, n_col)); // 바꿈
                             fishes.put(space[n_row][n_col].num, new fish_info_list(space[n_row][n_col].dir, cur.row, cur.col)); // 바뀜 당함

                             // 지도 위치 변경
                             Fish tmp = space[n_row][n_col];
                             space[n_row][n_col] = new Fish(space[cur.row][cur.col].num, (dir_idx + i) % 8); // 바꿈
                             space[cur.row][cur.col] = tmp; // 바뀜 당함
                         }
                         break; //바꾸면 끝
                     }
                 }
             }
             fish++;
         }

         // 상어 이동
        for(int k=1;k<=3;k++) { // 이동해 봤자 같은 방향으로 최대 3번 이동 가능
            int n_row = shark_row + dir_row[shark_dir] * k;
            int n_col = shark_col + dir_col[shark_dir] * k; // 3,3
            if (n_row < 0 || n_col < 0 || n_row > 3 || n_col > 3) { // 상어 갈 곳 없음
                 answer = Math.max(answer,sum);
                 return;
            }
            if(space[n_row][n_col]==null) continue; // 물고기가 없는 칸으로 이동한 경우

                // 지도 복사
                Fish [][] copy_space = new Fish[4][4];
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        copy_space[i][j] = space[i][j];
                    }
                }

                // 해시맵 복사
                HashMap<Integer,fish_info_list> copy_fishes = new HashMap<>();
                for(Integer f : fishes.keySet()){
                    copy_fishes.put(f, fishes.get(f));
                }

                int fish_dir = copy_space[n_row][n_col].dir;
                int fish_num = copy_space[n_row][n_col].num;

                copy_space[shark_row][shark_col] = null;
                copy_fishes.remove(fish_num); // 물고기 해시맵에서 제거


                dfs(sum + fish_num, copy_space, copy_fishes, n_row, n_col, fish_dir); // 물고기 잡아먹기 & 상어 위치 갱신

            }
        }
     }


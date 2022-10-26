import java.util.*;
import java.io.*;
class Main{
    static long house[];
    static int C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N; // 집, 공유기 수
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        house = new long[N];
        for(int i=0;i<N;i++){
            house[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(house);
        // 최소 거리에 대한 이분 탐색
        System.out.println(binarySearch(1, house[N-1]));
    }

    public static long binarySearch(long start, long last){
        long mid = 0;
        long answer = 0;

        while(start<=last){
            mid = (start+last)/2;
            int count = canInstall(mid);
            if(count<C){ // 거리 줄이기
               last = mid-1;
            }
            else { // 거리 늘리기
               start = mid+1;
               answer = mid;
            }
        }
        return answer;
    }
    public static int canInstall(long min_distance){

        int count = 1;
        long last_house = house[0];

        for(int i=1;i<house.length;i++){
            if((house[i]-last_house)>=min_distance){
                count++;
                last_house = house[i];
            }
        }
        return count;
    }

}
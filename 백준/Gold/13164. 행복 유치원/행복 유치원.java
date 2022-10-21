// 행복 유치원
import java.io.*;
import java.util.*;
class Main{
    static int N,K;
    static int arr[];
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        arr = new int[N];
        str=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Solution();
        System.out.println(answer);
    }
    public static void Solution(){
        Integer variation[] = new Integer[N-1];
        for(int i=0;i<N-1;i++){
            variation[i] = arr[i+1]-arr[i];
        }
        // 변화량이 큰 부분을 기준으로 자르면 됨
        // K개의 구간이므로 K-1번 잘라야 함
        Arrays.sort(variation);

       //K-1개 날리기
        for(int i=0;i<variation.length-(K-1);i++){
            answer+=variation[i];
        }

    }

}
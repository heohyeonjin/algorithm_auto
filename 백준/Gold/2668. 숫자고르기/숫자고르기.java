// 숫자 고르기
import java.io.*;
import java.util.*;
public class Main {
    static boolean visited[];
    static boolean isCycle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            if(arr[i]==i){
                visited[i] = true; // 동일
                continue;
            }

            if(visited[i]) continue;

            isCycle = false;

            getCycle(i,i,arr);
            
        }

        printResult();
    }

    public static void getCycle(int start, int v, int arr[]){

        if(start==arr[v]){
            visited[v] = true;
            isCycle = true;
            return;
        }

        int value = arr[v];

        if(!visited[v]){
            visited[v] = true;
            getCycle(start,value,arr);

            if(!isCycle){
                visited[v] = false;
            }
        }



    }

    public static void printResult(){
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<visited.length;i++){
            if(visited[i]){
                list.add(i);
                count++;
            }
        }
        System.out.println(count);
        for(int i=0;i<count;i++){
            System.out.println(list.get(i));
        }
    }
}

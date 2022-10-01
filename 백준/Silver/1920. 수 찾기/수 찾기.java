import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int arr[] = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(str[i]);
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");
        for(int i=0;i<M;i++){
            int key = Integer.parseInt(str[i]);
            System.out.println(binarySearch(arr,0,N-1,key));
        }
    }
    public static int binarySearch(int arr[], int start, int end, int key){
       //1,2,3,4,5
        while(start<=end){
            int mid = (start+end)/2; // 2
            if(arr[mid]==key) return 1;
            if(arr[mid]>key){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return 0;
    }
}
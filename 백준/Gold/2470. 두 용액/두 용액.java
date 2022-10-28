import java.util.*;
import java.io.*;
class Main{
    static int a,b;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        solve(arr);
        System.out.println(a+" "+b);
    }

    public static void solve(int [] arr){
        int left = 0;
        int right = N-1;
        long gap = Math.abs(arr[left]+arr[right]);
        int ans1 = 0;
        int ans2 = 0;
        while(left<right){

            if(Math.abs(arr[left] + arr[right]) <= gap){
                gap = Math.abs(arr[left]+arr[right]);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if(arr[left]+arr[right]>0){
                right--;
            }
            else{
                left++;
            }
        }

        a = ans1;
        b = ans2;
    }
}
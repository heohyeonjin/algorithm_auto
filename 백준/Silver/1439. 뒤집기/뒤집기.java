import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int arr[] = new int[2];

        char prev = s.charAt(0);
        for(char c : s.toCharArray()){
            if(prev!=c){
                if(prev=='0'){
                    arr[0]++;
                }
                else{
                    arr[1]++;
                }
            }
            prev = c;
        }
        int last = s.charAt(s.length()-1);
        if(last=='0'){
            arr[0]++;
        }
        else{
            arr[1]++;
        }

        System.out.println(Math.min(arr[0], arr[1]));


    }

}

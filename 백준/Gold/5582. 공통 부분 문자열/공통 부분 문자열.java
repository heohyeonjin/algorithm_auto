import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int answer = dp(str1,str2);
        System.out.println(answer);
    }

    public static int dp(String str1, String str2){
        int max = Integer.MIN_VALUE;
        int mem[][] = new int[str1.length()+1][str2.length()+1];

        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    mem[i+1][j+1] = mem[i][j]+1;
                    max = Math.max(max,mem[i+1][j+1]);
                }
            }
        }
        if(max == Integer.MIN_VALUE) max = 0;
        return max;
    }
}

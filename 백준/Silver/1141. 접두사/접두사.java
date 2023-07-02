import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String input[] = new String[N];
        for(int i=0;i<N;i++){
            input[i] = br.readLine();
        }

        Arrays.sort(input);
        int answer = N;
        for(int i=1;i<N;i++){
            if(input[i].startsWith(input[i-1])){
                answer--;
            }
        }

        System.out.println(answer);
    }
}

// 단어 수학
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int alpha[] = new int[26];

    Set<Character> set = new TreeSet<>();
    for(int i=0;i<N;i++){
        String input = br.readLine();
        for(int j=0;j<input.length();j++){
            int digitNum = input.length()-j-1;
            int value =(int) Math.pow(10,digitNum);
            alpha[input.charAt(j)-'A'] +=value;
            set.add(input.charAt(j));
        }
    }

    Arrays.sort(alpha);

    int answer = 0;
    int init=9;
    for(int i=25;i>=0;i--){
        if(alpha[i]==0) break;
        answer+=alpha[i]*init--;
    }
        System.out.println(answer);
    }
}


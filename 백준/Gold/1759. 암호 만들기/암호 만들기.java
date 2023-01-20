import java.util.*;
import java.io.*;
public class Main {
    static boolean visited[];
    static Character alpha[];
    static ArrayList<String> result;
    public static void main(String[] args) throws IOException{
        // 서로다른 L개의 알파벳 구성
        // C개의 문자 주어짐
        // 조합
        // 최소 1개의 모음(aeiou), 최소 2개의 자음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int L = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        alpha = new Character[C];
        char inp[] = br.readLine().toCharArray();
        for(int i=0;i<C;i++){
            alpha[i] = inp[i*2];
        }
        visited = new boolean[C];
        result = new ArrayList<>();
        Arrays.sort(alpha);
        dfs(0,L,C); // 조합

    }

    public static void dfs(int start, int r, int n) {
        if (r == 0) {
            int moem = 0;
            int zaem = 0;

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sb.append(alpha[i]);
                    if (alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u') {
                        moem++;
                    } else zaem++;
                }

            }
            if (moem >= 1 && zaem >= 2) {
                System.out.println(sb.toString());
            }
            return;
        }

            for (int i = start; i < n; i++) {
                visited[i] = true;
                dfs(i + 1, r - 1, n);
                visited[i] = false;
            }
        }
}

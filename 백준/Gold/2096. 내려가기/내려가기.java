import java.util.*;
import java.io.*;
// 내려가기
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dpMax[] = new int[3];
        int dpMin[] = new int[3];

        for(int i=0;i<N;i++){
            String input[] = br.readLine().split(" ");
            int cur1 = Integer.parseInt(input[0]);
            int cur2 = Integer.parseInt(input[1]);
            int cur3 = Integer.parseInt(input[2]);

            if(i==0){
                dpMax[0]=dpMin[0] = cur1;
                dpMax[1]=dpMin[1] = cur2;
                dpMax[2]=dpMin[2] = cur3;
            }
            else{
                int tmpdp0 = dpMax[0];
                int tmpdp2 = dpMax[2];

                dpMax[0] = Math.max(dpMax[0],dpMax[1])+cur1;
                dpMax[2] = Math.max(dpMax[1],dpMax[2])+cur3;
                dpMax[1] = Math.max(tmpdp2,Math.max(tmpdp0,dpMax[1]))+cur2;


                tmpdp0 = dpMin[0];
                tmpdp2 = dpMin[2];

                dpMin[0] = Math.min(dpMin[0],dpMin[1])+cur1;
                dpMin[2] = Math.min(dpMin[1],dpMin[2])+cur3;
                dpMin[1] = Math.min(tmpdp2,Math.min(tmpdp0,dpMin[1]))+cur2;

            }
        }

        int max = Math.max(dpMax[2],Math.max(dpMax[0],dpMax[1]));
        int min = Math.min(dpMin[2],Math.min(dpMin[0],dpMin[1]));

        System.out.printf(max+" "+min);

    }
}

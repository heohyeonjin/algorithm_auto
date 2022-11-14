
import java.util.*;
import java.io.*;
public class Main {
    static int tmpOperator[];
    static int operand[];
    static int operator[];
    static int minAnswer = Integer.MAX_VALUE;
    static int maxAnswer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int operandNum = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        operand = new int[input.length];
        for(int i=0;i<input.length;i++){
            operand[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        operator = new int[input.length];
        for(int i=0;i<input.length;i++){
            operator[i] = Integer.parseInt(input[i]);
        }
        tmpOperator = new int[operandNum-1];
        dfs(1,operandNum,operand[0]);

        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    public static void dfs(int depth, int n, int num){
        if(depth==n){
            maxAnswer = Math.max(num,maxAnswer);
            minAnswer = Math.min(num,minAnswer);
            return;
        }

        for(int i=0;i<operator.length;i++){
            if(operator[i]>0){
                operator[i]--;
                switch(i){
                    case 0 : dfs(depth+1,n,num+operand[depth]); break;
                    case 1 : dfs(depth+1, n, num-operand[depth]); break;
                    case 2 : dfs(depth+1,n,num*operand[depth]); break;
                    case 3 : dfs(depth+1,n,num/operand[depth]); break;
                }
                operator[i]++;
            }
        }
    }

}

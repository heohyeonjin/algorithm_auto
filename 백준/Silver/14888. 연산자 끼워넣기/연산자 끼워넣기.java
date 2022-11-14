
// 8:34
// 재귀
import java.util.*;
import java.io.*;
public class Main {
    static int tmpOperator[];
    static int operand[];
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
        int operator[] = new int[input.length];
        for(int i=0;i<input.length;i++){
            operator[i] = Integer.parseInt(input[i]);
        }
        tmpOperator = new int[operandNum-1];
        permu(0,operandNum,operator);

        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    public static void permu(int depth, int n, int[] operator){
        if(depth==n-1){
            evalute(tmpOperator);
            return;
        }
        int len = operator.length;
        int memOperator[] = new int[len];
        for(int i=0;i<len;i++){
            memOperator[i] = operator[i];
        }
        for(int i=0;i<len;i++){
            if(operator[i]>0){
                tmpOperator[depth] = i;
                operator[i]--;
                permu(depth+1, n, operator);

                for(int j=0;j<len;j++){
                    operator[j] = memOperator[j];
                }
            }
        }
    }

    public static void evalute(int tmpOperator[]){
        int tmp = operand[0];
        for(int i=1;i<operand.length;i++){
            if(tmpOperator[i-1]==0){ // 덧셈
                tmp+=operand[i];
            }
            else if(tmpOperator[i-1]==1){ // 뺄셈
                tmp-=operand[i];
            }
            else if(tmpOperator[i-1]==2){ // 곱셈
                tmp*=operand[i];
            }
            else{ // 나눗셈
                if(tmp<0){
                    tmp = Math.abs(tmp);
                    tmp/=operand[i];
                    tmp*=-1;
                }
                else{
                    tmp/=operand[i];
                }
            }
        }
        if(tmp<minAnswer){
            minAnswer = tmp;
        }
        if(tmp>maxAnswer){
            maxAnswer = tmp;
        }
    }

}

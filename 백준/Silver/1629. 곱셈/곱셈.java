import java.io.*;
public class Main {
    static long result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        result = A%C;
        DFS(A,B,C);
        System.out.println(result%C);
    }
    public static void DFS(int base, int exponent, int modular){

        if(exponent==1) return;

        DFS(base,exponent/2,modular);

        if(exponent%2==0){
            result = result*result % modular;
        }
        else{
            result = (result * result) % modular * base % modular;
        }

        result = result%modular;
    }
}

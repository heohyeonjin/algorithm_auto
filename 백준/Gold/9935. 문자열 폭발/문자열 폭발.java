import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 문자열 입력
        String bomb = br.readLine(); // 폭발 문자열

        String answer = explore(input, bomb);
        if(answer==""){
            System.out.println("FRULA");
        }
        else{
            System.out.println(answer);
        }
    }

    public static String explore(String input, String bomb){
        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()){ // O(n)
            stack.push(c);
            if(stack.size()>=bomb.length()){
                if(isBomb(stack,bomb)){
                    for(int i=0;i<bomb.length();i++) stack.pop();
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(char c : stack){
            sb.append(c);
        }
        return sb.toString();
    }

    public static boolean isBomb(Stack<Character> stack, String bomb){
        boolean flag = true;

        for(int i=0;i<bomb.length();i++){
            if(stack.get(stack.size()-i-1)!=bomb.charAt(bomb.length()-i-1)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}

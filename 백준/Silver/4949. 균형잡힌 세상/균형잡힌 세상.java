import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
           String input = br.readLine();
           if(input.equals(".")) break;
            System.out.println(solve(input));
       }
    }

    public static String solve(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == ')' || input.charAt(i) == ']') {
                if (stack.isEmpty()) return "no";
                if (input.charAt(i) == ')') {
                    if (stack.peek() == '(') stack.pop();
                    else return "no";
                } else if (input.charAt(i) == ']') {
                    if (stack.peek() == '[') stack.pop();
                    else return "no";
                }
            }
        }
        if(stack.isEmpty()) return "yes";
        else return "no";
    }

}
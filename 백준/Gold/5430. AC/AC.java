//AC
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            String answer = AC(p,n,arr);
            System.out.println(answer);
        }
    }

    public static String AC(String p, int n, String arr){
        Deque<Integer> dq = new LinkedList<>();

        // 배열 파싱 & 큐 삽입
        arr = arr.substring(1,arr.length()-1);
        String tmp[]= null;
        if(!arr.equals("")){
            tmp = arr.split(",");
        }
        if(tmp!=null){
            for(String x : tmp){
                dq.offer(Integer.parseInt(x));
            }
        }


        boolean R = false;
        for(char c : p.toCharArray()){
            if(c=='R'){ // 뒤집기
                if(R==false) R = true;
                else R = false;
            }
            else { // 삭제
                if(R){
                    if(dq.pollLast()==null){
                        return "error";
                    }
                }
                else{
                    if(dq.pollFirst()==null){
                        return "error";
                    }
                }
            }
        }

        String answer = print(dq,R);
        return answer;

    }

    public static String print(Deque<Integer> dq, boolean R){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while(!dq.isEmpty()){
            if(R){
                sb.append(dq.pollLast());
            }
            else{
                sb.append(dq.pollFirst());
            }
            sb.append(",");
        }
        if(sb.length()!=1){
            sb.delete(sb.length()-1,sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
}

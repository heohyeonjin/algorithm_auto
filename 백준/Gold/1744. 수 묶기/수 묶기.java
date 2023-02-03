import java.io.*;
import java.util.*;
public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> pn = new ArrayList<>();
        ArrayList<Integer> nn = new ArrayList<>();


        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num>0){
               pn.add(num);
            }
            else{
               nn.add(num);
            }
        }

        Collections.sort(pn,Collections.reverseOrder());
        Collections.sort(nn);


        Eval(pn);
        Eval(nn);



        System.out.println(answer);
    }
    public static void Eval(ArrayList<Integer> arr){
        int i=0;
        if(arr.size()!=1){
            while(i<arr.size()-1){
                if(arr.get(i)+arr.get(i+1)<=arr.get(i)*arr.get(i+1)){
                    answer+=arr.get(i)*arr.get(i+1);
                    i+=2;
                }
                else{
                    answer+=arr.get(i);
                    i++;
                }
            }
            if(i==arr.size()-1){
                answer+=arr.get(i);
            }
        }
        else{
            answer += arr.get(0);
        }
    }
}

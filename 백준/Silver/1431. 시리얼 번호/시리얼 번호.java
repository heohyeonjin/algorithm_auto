import java.io.*;
import java.util.*;
class Serial implements Comparable<Serial>{
    public String serial;
    public int numSum;
    public int numLen;
    public Serial(String serial, int numSum, int numLen){
        this.serial = serial;
        this.numSum = numSum;
        this.numLen = numLen;
    }

    @Override
    public int compareTo(Serial o){
        if(this.numLen==o.numLen){
            if(this.numSum==o.numSum){
                return this.serial.compareTo(o.serial);
            }
            else return this.numSum-o.numSum;
        }
        return this.numLen-o.numLen;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());
       String str[] = new String[N];

       for(int i=0;i<N;i++){
           str[i] = br.readLine();
       }


       Serial serial[] = new Serial[N];
       for(int i=0;i<N;i++){
           int sum = 0;
           for(char c : str[i].toCharArray()){
               if(c>='0' && c<='9'){
                   sum+=c-'0';
               }
           }
           serial[i] = new Serial(str[i],sum, str[i].length());
       }

       Arrays.sort(serial);

       for(int i=0;i<N;i++){
           System.out.println(serial[i].serial);
       }


    }
}

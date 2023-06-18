import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sortednums[] = new int[N];
        int nums[] = new int[N];
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
            sortednums[i] = nums[i];
        }

        Arrays.sort(sortednums);
        HashMap<Integer, Integer> orderMap = new HashMap<>();

        int order = 0;
        int prev = sortednums[0];
        for(int i=0;i<N;i++){
            if(prev!=sortednums[i]){
                order++;
            }
            orderMap.put(sortednums[i],order);
            prev = sortednums[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(orderMap.get(nums[i]));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}

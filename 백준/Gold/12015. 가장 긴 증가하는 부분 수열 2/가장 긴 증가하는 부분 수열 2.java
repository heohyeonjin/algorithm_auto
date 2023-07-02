import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int A[] = new int[N];
        String input[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        int LIS[] = new int[N];
        int lengthofLIS = 1;
        LIS[0] = A[0];


        for (int i = 1; i < N; i++) {
            int idx = binarySearch(0, lengthofLIS - 1, A[i], LIS);
            if (idx >= 0) {
                if (idx == lengthofLIS) {
                    LIS[lengthofLIS] = A[i];
                    lengthofLIS++;
                }
                else {
                    LIS[idx] = A[i];
                }
            }
        }
        System.out.println(lengthofLIS);
    }

    public static int binarySearch(int left, int right, int key, int[] LIS) {
        if (LIS[right] < key) {
            return right + 1;
        }

        int minValue = Integer.MAX_VALUE;
        int maxIndex = -1;
        while (left <= right) {

            int mid = (left + right) / 2;
            if (LIS[mid] >= key) {
                if(minValue>=LIS[mid]){
                    minValue = LIS[mid];
                    maxIndex = mid;
                }
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return maxIndex;
    }
}

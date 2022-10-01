import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		int count = 0;
		int arr[] = new int[N];
		for(int i = 0 ;i<N;i++) 
			arr[i] = scan.nextInt();
		N = N-1;
		while(K!=0) {
			if(arr[N] > K)
				N--;
			else if(arr[N]==K) {
				count++;
				break;
			}
			else {
				K= K-arr[N];
				count++;
			}				
			
		}
		System.out.println(count);

	}

}

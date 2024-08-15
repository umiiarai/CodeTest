import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChangeCoin2 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = -1;
		int N = Integer.parseInt(br.readLine());
		
		for (int i=N/5; i>=0; i--) {
			if ((N - (5 * i)) %2 == 0) {
				answer = i + (N - (5*i)) / 2;
				break;
			}
		}
		
		System.out.print(answer);
	}
}
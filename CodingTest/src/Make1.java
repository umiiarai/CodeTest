import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Make1 {
	
	static Integer[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;
		
		System.out.print(recur(N));
	}
	
	static int recur(int N) {
		
		if (dp[N] == null) {
			
			// 6���� �������� ���
			if (N % 6 == 0) {
				dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
			}
			// 3���� �������� ���
			else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
			}
			// 2�� �������� ���
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
			}
			// 2�� 3���� �������� �ʴ� ���
			else {
				dp[N] = recur(N - 1) + 1;
			}
		}
		
		return dp[N];
	}
}
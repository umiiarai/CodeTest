import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeBridge {
	
	static int[][] dp = new int[30][30];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			// M개 중 N개를 뽑는 경우이므로 nCr에서 n=M, r=N이다.
			// N = r
			int N = Integer.parseInt(st.nextToken());
			// M = n
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(combi(M, N)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int combi(int n, int r) {
		// 이미 풀린 경우 바로 반환
		if (dp[n][r] > 0) {
			return dp[n][r];
		}
		
		// 2번 성질
		if (n == r || r ==0) {
			return dp[n][r] = 1;
		}
		
		// 1번 성질
		return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
	}
}

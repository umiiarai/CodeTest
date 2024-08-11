import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Big {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N명의 집단 배열 생성
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		// N명의 몸무게, 키 입력받기
		String[] sp;
		for(int i=0; i<N; i++) {
			sp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(sp[0]);
			arr[i][1] = Integer.parseInt(sp[1]);
		}
		
		// 배열을 돌면서 몸무게, 키 비교하기
		for(int i=0; i<N; i++) {
			int rank = 1;
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			
			System.out.print(rank + " ");
		}
	}
}

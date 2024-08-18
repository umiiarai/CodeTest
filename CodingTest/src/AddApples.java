import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddApples {
	public static void main (String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	// 스크린 N칸
		int M = Integer.parseInt(st.nextToken());	// 바구니 M칸
		int j = Integer.parseInt(br.readLine());	// 사과의 개수
		
		int move = 0; 	// 이동 횟수 저장 횟수
		int start = 1;	// 바구니 시작 위치
		int end = M;	// 바구니 끝 위치
		
		// 사과 바구니에 담기 탐색
		for (int i=0; i<j; i++) {
			// 사과 떨어지는 위치
			int apple = Integer.parseInt(br.readLine());
			
			// 시작 위치 > 사과 위치
			if (start > apple) {
				// 이동한 거리 더하기
				move = move + start - apple;
				// 끝 위치 변경
				end = end - start - apple;
				// 시작 위치 변경
				start = apple;
			} else if (end < apple) {	// 끝 위치 < 사과 위치
				// 이동한 거리 더하기
				move = move + apple - end;
				// 시작 위치 변경
				start = start + apple - end;
				// 끝 위치 변경
				end = apple;
			}
		}
		
		System.out.print(move);
	}
}
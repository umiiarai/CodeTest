import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutLine {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 응시자 수, 수상자 수 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 길이가 N인 배열 생성
		int[] scoreArr = new int[N];
		
		// 점수 입력받기
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			scoreArr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		// 점수 오름차순 정렬
		Arrays.sort(scoreArr);
		
		System.out.println(scoreArr[N-K]);
	}
}

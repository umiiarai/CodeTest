import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutLine {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ������ ��, ������ �� �Է� �ޱ�
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// ���̰� N�� �迭 ����
		int[] scoreArr = new int[N];
		
		// ���� �Է¹ޱ�
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			scoreArr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		// ���� �������� ����
		Arrays.sort(scoreArr);
		
		System.out.println(scoreArr[N-K]);
	}
}

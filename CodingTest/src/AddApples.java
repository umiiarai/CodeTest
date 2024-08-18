import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddApples {
	public static void main (String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	// ��ũ�� Nĭ
		int M = Integer.parseInt(st.nextToken());	// �ٱ��� Mĭ
		int j = Integer.parseInt(br.readLine());	// ����� ����
		
		int move = 0; 	// �̵� Ƚ�� ���� Ƚ��
		int start = 1;	// �ٱ��� ���� ��ġ
		int end = M;	// �ٱ��� �� ��ġ
		
		// ��� �ٱ��Ͽ� ��� Ž��
		for (int i=0; i<j; i++) {
			// ��� �������� ��ġ
			int apple = Integer.parseInt(br.readLine());
			
			// ���� ��ġ > ��� ��ġ
			if (start > apple) {
				// �̵��� �Ÿ� ���ϱ�
				move = move + start - apple;
				// �� ��ġ ����
				end = end - start - apple;
				// ���� ��ġ ����
				start = apple;
			} else if (end < apple) {	// �� ��ġ < ��� ��ġ
				// �̵��� �Ÿ� ���ϱ�
				move = move + apple - end;
				// ���� ��ġ ����
				start = start + apple - end;
				// �� ��ġ ����
				end = apple;
			}
		}
		
		System.out.print(move);
	}
}
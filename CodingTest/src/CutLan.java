import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutLan {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[K];
		
		long max = 0;
		
		// �Է°� ���ÿ� �ش� ������ ���̰� �ִ������� Ȯ���ϰ� max�� ����
		for (int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		
		// �ݵ�� max���� +1 ���̾�� �Ѵ�.
		max++;
		
		long min = 0;
		long mid = 0;
		
		while (min < max) {
			// ���� ������ �߰� ���̸� ���Ѵ�.
			mid = (max + min) / 2;
			long count = 0;
			
			// ������ �߰� ���̷� �߶� �� �� ���� ��������� ���� ���Ѵ�.
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}
			
			/*
			 * uppder bound ����
			 * 
			 * mid ���̷� �߶��� ���� ������ ������� �ϴ� ������ �������� �۴ٸ�
			 * �ڸ����� �ϴ� ���̸� ���̱� ���� �ִ� ���̸� ���δ�.
			 * �� �ܿ��� �ڸ����� �ϴ� ���̸� �÷��� �ϹǷ� �ּ� ���̸� �ø���.
			 * */
			if (count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		// updderBound�� ����� ���� -1�� �ִ� ���̰� �ȴ�
		System.out.println(min - 1);
	}
}

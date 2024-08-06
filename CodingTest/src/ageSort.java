import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ageSort {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ȸ�� �� �Է¹ޱ�
		int n = Integer.parseInt(br.readLine());
        
		// �ԷµǴ� ������ ���� : 1 ~ 200
		StringBuilder[] p = new StringBuilder[201];
		
		// ��ü �迭�� �ε����� �� StringBuilder ��ü�� �������ش�.
		for(int i=0; i<p.length; i++) {
			p[i] = new StringBuilder();
		}
		
		// ȸ���� ���̿� �̸� �Է� �ޱ�
		for(int i=0; i<n; i++) {
			// Bufferedreader�� �� ���� �б� ������ ���ڿ� �и��� �ʿ��ѵ�
			// �̴� StringTokenizer�� ����Ͽ� ���ڿ��� �и�
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			// ī���� ���� : ���̸� index �� �Ͽ� �ش� �迭�� ���̿� �̸��� append() �Ѵ�
			p[age].append(age).append(' ').append(name).append('\n');
		}
		
		StringBuilder sb = new StringBuilder();
		for(StringBuilder val : p) {
			sb.append(val);
		}
		
		System.out.println(sb);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WomenPresident {
	
	public static int[][] APT = new int[15][15];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// ����Ʈ ����� 
		make_APT();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(APT[k][n]).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void make_APT() {
		for (int i=0; i<15; i++) {
			// i�� 1ȣ
			APT[i][1] = 1;
			// 0�� iȣ
			APT[0][i] = i;
		}
		
		// 1������ 14������
		for (int i=1; i<15; i++) {
			// 2ȣ���� 14ȣ����
			for(int j=2; j<15; j++) {
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}
	}
}
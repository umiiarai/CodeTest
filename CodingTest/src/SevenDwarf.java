import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenDwarf {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���̰� 9�� �迭 ����
		int[] heightArr = new int[9];
		
		// �����̵� Ű�� ����
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			int n = Integer.parseInt(br.readLine());
			heightArr[i] = n;
			sum += heightArr[i];
		}
		
		// Ű �������� ����
		Arrays.sort(heightArr);
		
		int a = 0;
		int b = 0;
		
		for(int i=0; i<heightArr.length-1; i++) {
			for(int j=i+1;j<heightArr.length; j++) {
				if(sum - heightArr[i] - heightArr[j] == 100) {
					a = i;
					b = j;
					break;
				}
			}
		}
		
		// ��¥ �ϰ������� Ű ���
		for(int i=0; i<heightArr.length; i++) {
			if(i != a && i != b) {
				System.out.println(heightArr[i]);
			}
		}
	}

}
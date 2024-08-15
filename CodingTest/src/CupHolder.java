import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CupHolder {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		String str = "";
		
		for (int i=0; i<n; i++) {
			if (s.charAt(i) == 'S') { // S(�Ϲݼ��̸�) * �߰�
				str += "*S";
			} else {
				str += "*LL"; // L(Ŀ�ü��̸�) 2ĭ �Ѿ �� * �߰�
				i++;
			}
		}
		
		str += "*"; // ������ �ڸ��� * �߰�
		int count = 0;
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '*') count++;
		}
		count = Math.min(count, n);
		System.out.println(count);
	}

}
import java.util.Scanner;

public class ChangeCoin {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// ������ �� �Է¹ޱ�
		int payment = sc.nextInt();
		
		// �Ž����� ����ϱ�
		int change = changeCalculator(payment);
		
		System.out.print(change);
	}
	
	public static int changeCalculator(int payment) {
		// �ܵ��� ����
		int[] coins = {500, 100, 50, 10, 5, 1};
		// �ܵ��� ������ ������ �迭
		int[] changeCount = new int[coins.length];
		
		// ���� �ܵ�
		int remainingChange = 1000 - payment;
		
		for (int i=0; i<coins.length; i++) { // ������ ū �ܵ����� ����
			changeCount[i] = remainingChange / coins[i];
			remainingChange = remainingChange % coins[i];
		}
		
		// ���� ���� ���ϱ�
		int totalChangeCount = 0;
		for (int count : changeCount) {
			totalChangeCount = totalChangeCount + count;
		}
		
		return totalChangeCount;
	}
}

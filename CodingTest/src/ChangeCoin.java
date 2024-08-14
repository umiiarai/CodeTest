import java.util.Scanner;

public class ChangeCoin {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 내야할 돈 입력받기
		int payment = sc.nextInt();
		
		// 거스름돈 계산하기
		int change = changeCalculator(payment);
		
		System.out.print(change);
	}
	
	public static int changeCalculator(int payment) {
		// 잔돈의 종류
		int[] coins = {500, 100, 50, 10, 5, 1};
		// 잔돈의 개수를 저자할 배열
		int[] changeCount = new int[coins.length];
		
		// 받을 잔돈
		int remainingChange = 1000 - payment;
		
		for (int i=0; i<coins.length; i++) { // 단위가 큰 잔돈부터 돌기
			changeCount[i] = remainingChange / coins[i];
			remainingChange = remainingChange % coins[i];
		}
		
		// 동전 개수 구하기
		int totalChangeCount = 0;
		for (int count : changeCount) {
			totalChangeCount = totalChangeCount + count;
		}
		
		return totalChangeCount;
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bingo {
	static int board[][] = new int[5][5];
	static int[] order = new int[25];
	static int bingo = 0;
	static int turn = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// ������ �Է¹ޱ�
		for (int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ��ȸ�� ��ȣ �Է¹ޱ�
		int n = 0;
		for (int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				order[n] = Integer.parseInt(st.nextToken());
				n++;
			}
		}
		
		// ���� ã��
		for (int i=0; i<25; i++) {
			// �ش� ���ڸ� ���� �ִ� ĭ�� ã�� 0���� ǥ��
			for (int k=0; k<5; k++) {
				for (int l=0; l<5; l++) {
					if (board[k][l] == order[i])
						board[k][l] = 0;
				}
			}
			
			col(); // ��
			row(); // ��
			diag1(); // �밢1
			diag2(); // �밢2
			
			// 3�� ������ ���
			if (bingo >=3) {
				// �� ��� �� ����
				System.out.println(turn);
				return;
			}
			
			// �ʱ�ȭ
			bingo = 0;
			// �� ����
			turn++;
		}
	}
	
	// �� üũ
	public static void col() {
		for (int i=0; i<5; i++) {
			int count = 0;
			for (int j=0; j<5; j++) {
				if (board[i][j] == 0)
					count++;
				if (count == 5)
					bingo++;
			}
		}
	}
	
	// �� üũ
	public static void row() {
		for (int i = 0; i < 5; i++) {
			int count = 0;
			
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == 0)
					count++;
				if (count == 5)
					bingo++;
			}
		}
	}
	
	// �밢�� üũ (���� �Ʒ� > ������ ��)
	public static void diag1() {
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			if (board[i][4 - i] == 0)
				count++;
			if (count == 5)
				bingo++;
		}
	}
	
	// �밢�� üũ (���� �� > ������ �Ʒ�)
	public static void diag2() {
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			if (board[i][i] == 0)
				count++;
			if (count == 5)
				bingo++;
		}
	}
}

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
		
		// 빙고판 입력받기
		for (int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자 번호 입력받기
		int n = 0;
		for (int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				order[n] = Integer.parseInt(st.nextToken());
				n++;
			}
		}
		
		// 빙고 찾기
		for (int i=0; i<25; i++) {
			// 해당 숫자를 갖고 있는 칸을 찾아 0으로 표시
			for (int k=0; k<5; k++) {
				for (int l=0; l<5; l++) {
					if (board[k][l] == order[i])
						board[k][l] = 0;
				}
			}
			
			col(); // 열
			row(); // 행
			diag1(); // 대각1
			diag2(); // 대각2
			
			// 3줄 빙고의 경우
			if (bingo >=3) {
				// 턴 출력 후 종료
				System.out.println(turn);
				return;
			}
			
			// 초기화
			bingo = 0;
			// 턴 증가
			turn++;
		}
	}
	
	// 열 체크
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
	
	// 행 체크
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
	
	// 대각선 체크 (왼쪽 아래 > 오른쪽 위)
	public static void diag1() {
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			if (board[i][4 - i] == 0)
				count++;
			if (count == 5)
				bingo++;
		}
	}
	
	// 대각선 체크 (왼쪽 위 > 오른쪽 아래)
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenDwarf {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 길이가 9인 배열 생성
		int[] heightArr = new int[9];
		
		// 난쟁이들 키의 총합
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			int n = Integer.parseInt(br.readLine());
			heightArr[i] = n;
			sum += heightArr[i];
		}
		
		// 키 오름차순 정렬
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
		
		// 진짜 일곱난장이 키 출력
		for(int i=0; i<heightArr.length; i++) {
			if(i != a && i != b) {
				System.out.println(heightArr[i]);
			}
		}
	}

}
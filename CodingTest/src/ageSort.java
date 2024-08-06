import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ageSort {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 회원 수 입력받기
		int n = Integer.parseInt(br.readLine());
        
		// 입력되는 나이의 범위 : 1 ~ 200
		StringBuilder[] p = new StringBuilder[201];
		
		// 객체 배열의 인덱스에 각 StringBuilder 객체를 생성해준다.
		for(int i=0; i<p.length; i++) {
			p[i] = new StringBuilder();
		}
		
		// 회원의 나이와 이름 입력 받기
		for(int i=0; i<n; i++) {
			// Bufferedreader는 한 줄을 읽기 때문에 문자열 분리가 필요한데
			// 이는 StringTokenizer을 사용하여 문자열을 분리
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			// 카운팅 정렬 : 나이를 index 로 하여 해당 배열에 나이와 이름을 append() 한다
			p[age].append(age).append(' ').append(name).append('\n');
		}
		
		StringBuilder sb = new StringBuilder();
		for(StringBuilder val : p) {
			sb.append(val);
		}
		
		System.out.println(sb);
	}
}

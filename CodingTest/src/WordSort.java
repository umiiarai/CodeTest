import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class WordSort {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		
		for(int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String w1, String w2) {
				if(w1.length() == w2.length()) { // 단어 길이가 같을 경우
					return w1.compareTo(w2);
				} else { // 단어 길이가 다를 경우
					return w1.length() - w2.length();
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		sb.append(words[0]).append('\n');
		
		for(int i=1; i<N; i++) {
			// 중복 되지 않은 단어만 출력
			if(!words[i].equals(words[i-1])) {
				sb.append(words[i]).append('\n');
			}
		}
		System.out.println(sb);
	}
}

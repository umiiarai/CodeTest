import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Birthday {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Person> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			list.add(new Person(input));
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(N-1));
		System.out.println(list.get(0));
	}
	
	static class Person implements Comparable<Person> {
		String name;
		int dd;
		int mm;
		int yyyy;
		
		Person(String[] input) {
			this.name = input[0];
			dd = Integer.parseInt(input[1]);
			mm = Integer.parseInt(input[2]);
			yyyy = Integer.parseInt(input[3]);
		}
		
		@Override
		public int compareTo(Person o) {
			if(this.yyyy == o.yyyy) {
				if(this.mm == o.mm) {
					return Integer.compare(this.dd, o.dd);
				}
				return Integer.compare(this.mm, o.mm);
			}
			return Integer.compare(this.yyyy, o.yyyy);
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
}

import java.io.*;
import java.util.*;
public class FindNum {
	
	//N개의 정수 저장 배열
	static int[] arr;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[size];
        
        for(int i=0;i<size;i++)
        	arr[i] = Integer.parseInt(st.nextToken());
        
      //배열 오름차순 정렬
        Arrays.sort(arr);
        
      //찾는 수 개수
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        
        for(int i = 0;i<M;i++) {
        	int num = Integer.parseInt(st.nextToken());
        	bw.write(find(num) + "\n");
        }
        
      //결과 출력
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int n) {
    	int size = arr.length;
    	int start = 0;							//시작값
    	int end = arr.length-1;					//최대값
    	
    	while(!(size==0)) {
    		int median = (start + end)/2;		//중간값
    		if(arr[median]==n) {				//찾는 값 동일한 경우
    			return 1;
    		}else if(arr[median]>n) {			//중간값이 찾는값보다 큰 경우
    			end = median-1;
    		}else {								//중간값이 찾는값보다 작은 경우
    			start = median + 1;
    		}
    		size /= 2;
    	}
       	return 0;								//배열에 찾는 값이 없을때 반환
    }
}
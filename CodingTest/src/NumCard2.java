import java.io.*;
import java.util.*;
public class NumCard2 {
	//카드 수 저장하는 배열
	static int[] card;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        card = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) 
        	card[i] = Integer.parseInt(st.nextToken());
        
        //오름차순 정렬
        Arrays.sort(card);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<M;i++) {
        	int num = Integer.parseInt(st.nextToken());
        	//Start 구하기
        	int start = cardStart(num);
        	//End 구하기
        	int end = cardEnd(num);
        	
        	//입력값이 배열에 존재하지 않을 경우
        	if(start == end)
        		bw.write(0 + "\n");
        	else
        		bw.write((end - start) + "\n");
        }
        
        //결과 출력
        bw.flush();
        bw.close();
        br.close();
    }
    
    //Start 구하는 함수
    public static int cardStart(int n) {
    	int start = 0;
    	int end = card.length;
    	while(start<end) {
    		int median = (start + end)/2;
    		if(card[median]>=n) 
    			end = median;
    		else
    			start = median + 1;
    	}
    	return start;
    }
    
    //End 구하는 함수
    public static int cardEnd(int n) {
    	int start = 0;
    	int end = card.length;
    	while(start<end) {
    		int median = (start + end)/2;
    		if(card[median]<=n) {
    			start = median + 1;
    		}else
    			end = median;
    	}
    	return start;
    }
}
import java.io.*;
import java.util.*;
public class NumCard2 {
	//ī�� �� �����ϴ� �迭
	static int[] card;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        card = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) 
        	card[i] = Integer.parseInt(st.nextToken());
        
        //�������� ����
        Arrays.sort(card);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<M;i++) {
        	int num = Integer.parseInt(st.nextToken());
        	//Start ���ϱ�
        	int start = cardStart(num);
        	//End ���ϱ�
        	int end = cardEnd(num);
        	
        	//�Է°��� �迭�� �������� ���� ���
        	if(start == end)
        		bw.write(0 + "\n");
        	else
        		bw.write((end - start) + "\n");
        }
        
        //��� ���
        bw.flush();
        bw.close();
        br.close();
    }
    
    //Start ���ϴ� �Լ�
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
    
    //End ���ϴ� �Լ�
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
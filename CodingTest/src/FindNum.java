import java.io.*;
import java.util.*;
public class FindNum {
	
	//N���� ���� ���� �迭
	static int[] arr;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[size];
        
        for(int i=0;i<size;i++)
        	arr[i] = Integer.parseInt(st.nextToken());
        
      //�迭 �������� ����
        Arrays.sort(arr);
        
      //ã�� �� ����
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        
        for(int i = 0;i<M;i++) {
        	int num = Integer.parseInt(st.nextToken());
        	bw.write(find(num) + "\n");
        }
        
      //��� ���
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int n) {
    	int size = arr.length;
    	int start = 0;							//���۰�
    	int end = arr.length-1;					//�ִ밪
    	
    	while(!(size==0)) {
    		int median = (start + end)/2;		//�߰���
    		if(arr[median]==n) {				//ã�� �� ������ ���
    			return 1;
    		}else if(arr[median]>n) {			//�߰����� ã�°����� ū ���
    			end = median-1;
    		}else {								//�߰����� ã�°����� ���� ���
    			start = median + 1;
    		}
    		size /= 2;
    	}
       	return 0;								//�迭�� ã�� ���� ������ ��ȯ
    }
}
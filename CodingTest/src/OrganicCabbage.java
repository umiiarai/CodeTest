import java.io.*;
import java.util.*;
public class OrganicCabbage {
	public static int T,N,M,K,count;
	public static int[][] earth;		//���� ���� ���� ���� �迭
	public static int[] dx = {-1, 1, 0, 0};	//��,��,��,�� x ��ȭ��
	public static int[] dy = {0, 0, -1, 1};	//��,��,��,�� y ��ȭ��
	public static boolean[][] check;	//�� Ž�� ����
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //�Է°� ó���ϴ� BufferedReader
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //����� ����ϴ� BufferedWriter
        //--------�Է°� ó�� �� �迭 �ʱ�ȭ-------
    	T = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	for(int i=0;i<T;i++) {
    		count = 0;
    		st = new StringTokenizer(br.readLine()," ");
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		K = Integer.parseInt(st.nextToken());
    		earth = new int[N][M];
    		check = new boolean[N][M];
    		for(int j=0;j<K;j++) {
    			st = new StringTokenizer(br.readLine()," ");
    			int X = Integer.parseInt(st.nextToken());
    			int Y = Integer.parseInt(st.nextToken());
    			earth[X][Y] = 1;
    		}
           	 //------�� �� ���� dfs Ž��-------
    		for(int j=0;j<N;j++) {
    			for(int s=0;s<M;s++) {
    				if(!check[j][s] && earth[j][s]==1) {
    					check[j][s] = true;	//�ش� �� Ž�� �Ϸ�
    					dfs(j,s);		//DFS Ž��
    					count++;		//���� �߰�
    				}
    			}
    		}
    		bw.write(count + "\n");		//��� BufferedWriter ����
    	}
    	bw.flush();		//��� ���
    	bw.close();
    	br.close();
    }
    public static void dfs(int x, int y) {
    	for(int i=0;i<4;i++) {
    		int tempX = x + dx[i];		//��,��,��,�� x�� ����
    		int tempY = y + dy[i];		//��,��,��,�� y�� ����
    		if(tempX>=0 && tempX<N && tempY>=0 && tempY<M && !check[tempX][tempY]) {
            		//Ž�� ������ ���� ��
    			check[tempX][tempY] = true;		//Ž�� �Ϸ�
    			if(earth[tempX][tempY]==1)
    				dfs(tempX,tempY);		//DFS Ž��
    		}
    	}
    	return;
    }
}
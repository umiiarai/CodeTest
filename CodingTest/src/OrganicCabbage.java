import java.io.*;
import java.util.*;
public class OrganicCabbage {
	public static int T,N,M,K,count;
	public static int[][] earth;		//땅의 배추 유무 저장 배열
	public static int[] dx = {-1, 1, 0, 0};	//상,하,좌,우 x 변화값
	public static int[] dy = {0, 0, -1, 1};	//상,하,좌,우 y 변화값
	public static boolean[][] check;	//땅 탐색 유무
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
        //--------입력값 처리 및 배열 초기화-------
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
           	 //------각 땅 기준 dfs 탐색-------
    		for(int j=0;j<N;j++) {
    			for(int s=0;s<M;s++) {
    				if(!check[j][s] && earth[j][s]==1) {
    					check[j][s] = true;	//해당 땅 탐색 완료
    					dfs(j,s);		//DFS 탐색
    					count++;		//구역 추가
    				}
    			}
    		}
    		bw.write(count + "\n");		//결과 BufferedWriter 저장
    	}
    	bw.flush();		//결과 출력
    	bw.close();
    	br.close();
    }
    public static void dfs(int x, int y) {
    	for(int i=0;i<4;i++) {
    		int tempX = x + dx[i];		//상,하,좌,우 x값 변경
    		int tempY = y + dy[i];		//상,하,좌,우 y값 변경
    		if(tempX>=0 && tempX<N && tempY>=0 && tempY<M && !check[tempX][tempY]) {
            		//탐색 가능한 땅일 때
    			check[tempX][tempY] = true;		//탐색 완료
    			if(earth[tempX][tempY]==1)
    				dfs(tempX,tempY);		//DFS 탐색
    		}
    	}
    	return;
    }
}
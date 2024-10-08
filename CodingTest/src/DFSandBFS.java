import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSandBFS {
	public static int N, M, V;	//정점,간선, 시작 정점
	public static int[][] graph;	//i,j가 인접하는지 확인 배열
	public static boolean[] check;		//정점 탐색했는지 확인 배열
	public static StringBuilder sb = new StringBuilder();	//결과

	public static void main(String[] args) throws Exception{
		// 입력값 처리되는 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 결과값 출력하는 BufferedWriter
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력값 저장 및 배열 초기화
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	V = Integer.parseInt(st.nextToken());
    	graph = new int[N+1][N+1];
    	check = new boolean[N+1];
    	
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
            /*
            정점 i와 정점 j가 인접하다는 것은
            [i][j] = 1, [j][i]= 1로 표현해야 합니다.
            */
    		graph[x][y]=1;
    		graph[y][x]=1;
    	}
    	
    	dfs(V);		// dfs 탐색 함수 실행
    	sb.append("\n");
    	check = new boolean[N+1];		// 탐색 확인 배열 초기화
    	bfs(V);		// bfs 탐색 함수 실행
    	bw.write(sb.toString());		// dfs와 bfs탐색 순서 BufferedWriter 저장
    	bw.flush();			// 결과 출력
    	bw.close();
    	br.close();
	}
	
	public static void dfs(int cur) {
    	sb.append(cur + " ");
    	check[cur] = true;		// 해당 정점 탐색 완료
    	
    	for(int i=1;i<=N;i++) {		// 조건이 낮은 정점 먼저 탐색이므로 1부터 반복시작
    		if(graph[cur][i]==1 && !check[i]) {
    			dfs(i);		// 인접한 정점 중 탐색 가능하면 탐색
    		}
    	}
    	return;
    }
	
    public static void bfs(int start) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	sb.append(start + " ");
    	check[start] = true;	// 시작 정점 탐색 완료
    	queue.offer(start);		// 시작 정점 기준 정점으로 사용하기 위해 Queue에 저장
    	while(!queue.isEmpty()) {
    		int location = queue.poll();	// 기준 정점
    		for(int i=1;i<=N;i++) {	// 조건이 낮은 정점 먼저 탐색으로 1부터 반복시작
    			if(graph[location][i]==1 && !check[i]) {
                		// 기준 정점 기준으로 인접한 정점 탐색
    				check[i] = true;
    				queue.offer(i);
    				sb.append(i + " ");
    			}
    		}
    	}
    	return;
    }
}

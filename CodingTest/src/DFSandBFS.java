import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSandBFS {
	public static int N, M, V;	//����,����, ���� ����
	public static int[][] graph;	//i,j�� �����ϴ��� Ȯ�� �迭
	public static boolean[] check;		//���� Ž���ߴ��� Ȯ�� �迭
	public static StringBuilder sb = new StringBuilder();	//���

	public static void main(String[] args) throws Exception{
		// �Է°� ó���Ǵ� BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ����� ����ϴ� BufferedWriter
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // �Է°� ���� �� �迭 �ʱ�ȭ
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
            ���� i�� ���� j�� �����ϴٴ� ����
            [i][j] = 1, [j][i]= 1�� ǥ���ؾ� �մϴ�.
            */
    		graph[x][y]=1;
    		graph[y][x]=1;
    	}
    	
    	dfs(V);		// dfs Ž�� �Լ� ����
    	sb.append("\n");
    	check = new boolean[N+1];		// Ž�� Ȯ�� �迭 �ʱ�ȭ
    	bfs(V);		// bfs Ž�� �Լ� ����
    	bw.write(sb.toString());		// dfs�� bfsŽ�� ���� BufferedWriter ����
    	bw.flush();			// ��� ���
    	bw.close();
    	br.close();
	}
	
	public static void dfs(int cur) {
    	sb.append(cur + " ");
    	check[cur] = true;		// �ش� ���� Ž�� �Ϸ�
    	
    	for(int i=1;i<=N;i++) {		// ������ ���� ���� ���� Ž���̹Ƿ� 1���� �ݺ�����
    		if(graph[cur][i]==1 && !check[i]) {
    			dfs(i);		// ������ ���� �� Ž�� �����ϸ� Ž��
    		}
    	}
    	return;
    }
	
    public static void bfs(int start) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	sb.append(start + " ");
    	check[start] = true;	// ���� ���� Ž�� �Ϸ�
    	queue.offer(start);		// ���� ���� ���� �������� ����ϱ� ���� Queue�� ����
    	while(!queue.isEmpty()) {
    		int location = queue.poll();	// ���� ����
    		for(int i=1;i<=N;i++) {	// ������ ���� ���� ���� Ž������ 1���� �ݺ�����
    			if(graph[location][i]==1 && !check[i]) {
                		// ���� ���� �������� ������ ���� Ž��
    				check[i] = true;
    				queue.offer(i);
    				sb.append(i + " ");
    			}
    		}
    	}
    	return;
    }
}

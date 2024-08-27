import java.util.*;

public class Virus {
	
    public static int[][] node;
    public static boolean[] visited;
    public static int M,N;
    public static int result = 0;
    
    public static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.offer(start);

        while(!que.isEmpty()) {
            int temp = que.poll(); //현재 위치 저장

            for(int i=1; i<=M; i++) {
                if(node[temp][i] == 1 && !visited[i]){
                    que.offer(i);
                    visited[i] = true;
                    result ++;
                }
            }
        }

        return result;
    }
    
	public static void main(String[] args) throws Exception {
		
        Scanner sc = new Scanner(System.in);
		
        M = sc.nextInt();
        N = sc.nextInt();
 
        node = new int[M+1][M+1];
        visited = new boolean[M+1];
 
        for(int i=0; i<N; i++){
           int m = sc.nextInt();
           int n = sc.nextInt();
           node[m][n] = node[n][m] = 1;
        }
        
        System.out.println(bfs(1));
	}
}
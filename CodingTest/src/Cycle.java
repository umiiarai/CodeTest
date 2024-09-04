import java.util.Scanner;

public class Cycle{
    static int[] graph;
    static boolean[] visited;
    
    public static void dfs(int index){
        visited[index] = true;
        if(!visited[graph[index]]) dfs(graph[index]);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc=0; tc<T; tc++){
            int N = sc.nextInt();
            
            int cnt = 0;
            graph = new int[N+1];
            visited = new boolean[N+1];
            
            for(int i=1; i<=N; i++) graph[i] = sc.nextInt();
            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    dfs(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
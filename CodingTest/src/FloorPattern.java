import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FloorPattern {
	
	static int row, col;
	static char[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] rowCol = br.readLine().split(" ");
	    row = Integer.parseInt(rowCol[0]);
	    col = Integer.parseInt(rowCol[1]);
	    arr = new char[row][col];
	    visited = new boolean[row][col];

	    for (int i = 0; i < row; i++) {
	      String s = br.readLine();
	      for (int j = 0; j < col; j++) {
	        arr[i][j] = s.charAt(j);
	      }
	    }

	    int count = 0;
	    for (int i = 0; i < row; i++) {
	      for (int j = 0; j < col; j++) {
	        if (visited[i][j]) {
	          continue;
	        } else if (arr[i][j] == '-') {
	          dfs(i, j, true);
	        } else {
	          dfs(i, j, false);
	        }
	        count++;
	      }
	    }

	    System.out.println(count);

	  }

	  public static void dfs(int i, int j, boolean horizontal) {
	    visited[i][j] = true;
	    if (horizontal) {
	      j++;
	      if (j < col && arr[i][j] == '-') {
	        dfs(i, j, true);
	      }
	    } else {
	      i++;
	      if (i < row && arr[i][j] == '|') {
	        dfs(i, j, false);
	      }
	    }
	  }
}

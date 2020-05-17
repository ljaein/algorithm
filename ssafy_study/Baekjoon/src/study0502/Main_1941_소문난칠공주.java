package study0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1941_소문난칠공주 {

	static char[][] map = new char[5][5];
	static boolean[][] visit;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 5; j++) {
				map[i][j] = c[j];
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				visit = new boolean[5][5];
				if (map[i][j] == 'S')
					dfs(i, j, 0, 1);
				else
					dfs(i, j, 0, 0);
			}
		}

	}

	static void dfs(int y, int x, int cnt, int scnt) {
		visit[y][x]=true;
		for(int d=0;d<4;d++){
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(ny<0||nx<0||ny>=5||nx>=5||visit[ny][nx])
				continue;
			if(map[ny][nx])
		}
	}

}

package study0604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3709_레이저빔은어디로 {

	static int T, n, r, nd;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			map = new int[n + 2][n + 2];
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				int my = Integer.parseInt(st.nextToken());
				int mx = Integer.parseInt(st.nextToken());
				map[my][mx] = 1;// 거울
			}
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if (y == 0)
				nd = 2;
			else if (y == n + 1)
				nd = 0;
			else if (x == 0)
				nd = 1;
			else if (x == n + 1)
				nd = 3;
			go(y, x);
		}
	}

	static void go(int y, int x) {
		int ny = y + dy[nd];
		int nx = x + dx[nd];
		if (ny <= 0 || nx <= 0 || ny >= n + 1 || nx >= n + 1) {
			System.out.println(ny+" "+nx);
			return;
		}
		if (map[ny][nx] == 0) {
			go(ny, nx);
		} else if (map[ny][nx] == 1) {
			nd = nd == 3 ? 0 : nd + 1;
			go(ny, nx);
		}

	}

}

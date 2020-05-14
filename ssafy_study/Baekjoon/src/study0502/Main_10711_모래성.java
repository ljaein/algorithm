package study0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10711_모래성 {

	static int H, W, ans;
	static int[][] map, cnt;
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		cnt = new int[H][W];
		for (int i = 0; i < H; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				if (c[j] == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = c[j] - '0';
				}
			}
		}
		wave();
		System.out.println(ans);
	}

	static void wave() {
		Queue<Point> q = new LinkedList<>();
		for (int i = 1; i < H - 1; i++) {
			for (int j = 1; j < W - 1; j++) {
				if (map[i][j] == 0)
					continue;
				for (int d = 0; d < 8; d++) {
					if (map[i + dy[d]][j + dx[d]] == 0)
						cnt[i][j]++;
				}
				if (map[i][j] <= cnt[i][j])
					q.add(new Point(i, j));
			}
		}
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point cur = q.poll();
				map[cur.y][cur.x] = 0;
				for (int d = 0; d < 8; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];
					if (map[ny][nx] == 0)
						continue;
					if (cnt[ny][nx] < map[ny][nx]) {
						cnt[ny][nx]++;
						if (cnt[ny][nx] >= map[ny][nx])
							q.add(new Point(ny, nx));
					}
				}
			}
			ans++;
		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

}

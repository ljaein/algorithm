package study0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1445_일요일아침의데이트 {

	static int N, M, ey, ex, sy, sx, ans_g, ans_n;
	static int[][] map;
	static int[][][] visit;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M][2];
		ans_g = Integer.MAX_VALUE;
		ans_n = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(visit[i][j], Integer.MAX_VALUE);
			}
		}
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (c[j] == '.')
					map[i][j] = 0;
				else if (c[j] == 'g')
					map[i][j] = 1;
				else if (c[j] == 'F') {
					ey = i;
					ex = j;
				} else {
					sy = i;
					sx = j;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] != 0 || (ny == sy && nx == sx))
							continue;
						map[ny][nx] = 2;
					}
				}
			}
		}
		bfs();
		System.out.println(ans_g + " " + ans_n);
	}

	static void bfs() {
		visit[sy][sx][0] = 0;
		visit[sy][sx][1] = 0;
		q.add(new Point(sy, sx, 0, 0));
		w: while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx][0] < cur.g)
					continue;
				if (visit[ny][nx][0] == cur.g && visit[ny][nx][1] <= cur.next)
					continue;
				if (ny == ey && nx == ex) {
					if (ans_g > cur.g) {
						ans_g = cur.g;
						ans_n = cur.next;
					} else if (ans_g == cur.g) {
						if (ans_n > cur.next) {
							ans_g = cur.g;
							ans_n = cur.next;
						}
					}
					continue w;
				}
				if (map[ny][nx] == 0) {
					visit[ny][nx][0] = cur.g;
					visit[ny][nx][1] = cur.next;
					q.add(new Point(ny, nx, cur.g, cur.next));
				} else if (map[ny][nx] == 1) {
					if (visit[ny][nx][0] > cur.g + 1 || (visit[ny][nx][0] == cur.g + 1 && visit[ny][nx][1] > cur.next)) {
						visit[ny][nx][0] = cur.g + 1;
						visit[ny][nx][1] = cur.next;
						q.add(new Point(ny, nx, cur.g + 1, cur.next));
					}
				} else if (map[ny][nx] == 2) {
					if (visit[ny][nx][0] > cur.g || (visit[ny][nx][0] == cur.g && visit[ny][nx][1] > cur.next + 1)) {
						visit[ny][nx][0] = cur.g;
						visit[ny][nx][1] = cur.next + 1;
						q.add(new Point(ny, nx, cur.g, cur.next + 1));
					}
				}
			}
		}
	}

	static class Point {
		int y, x, g, next;

		public Point(int y, int x, int g, int next) {
			this.y = y;
			this.x = x;
			this.g = g;
			this.next = next;
		}

	}

}

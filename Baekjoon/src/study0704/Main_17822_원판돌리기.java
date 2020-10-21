package study0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기 {

	static int N, M, T;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 원판
		M = Integer.parseInt(st.nextToken()); // 몇칸
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			rotate(x, d, k);
			if (adj())
				continue;
			else
				avg();
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans);
	}

	static void rotate(int x, int d, int k) {
		for (int i = 0; i < N; i++) {
			if ((i + 1) % x == 0) {// x의 배수인 원판인 경우
				if (d == 0) {// 시계방향
					int[] temp = new int[M];
					for (int j = 0; j < M; j++) {
						int idx = j + k;
						while (idx >= M) {
							idx -= M;
						}
						temp[idx] = map[i][j];
					}
					System.arraycopy(temp, 0, map[i], 0, M);
				} else if (d == 1) {// 반시계방향
					int[] temp = new int[M];
					for (int j = 0; j < M; j++) {
						int idx = j - k;
						while (idx < 0) {
							idx += M;
						}
						temp[idx] = map[i][j];
					}
					System.arraycopy(temp, 0, map[i], 0, M);
				}
			}
		} // 원판 회전
	}

	static boolean adj() {
		List<Point> del = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;
				int l = j == 0 ? M - 1 : j - 1;
				int r = j == M - 1 ? 0 : j + 1;
				if (map[i][j] == map[i][l]) {
					del.add(new Point(i, j));
					del.add(new Point(i, l));
				}
				if (map[i][j] == map[i][r]) {
					del.add(new Point(i, j));
					del.add(new Point(i, r));
				}
			}
		}

		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 0)
					continue;
				if (i == 0) {
					if (map[i][j] == map[i + 1][j]) {
						del.add(new Point(i, j));
						del.add(new Point(i + 1, j));
					}
				} else if (i == N - 1) {
					if (map[i][j] == map[i - 1][j]) {
						del.add(new Point(i, j));
						del.add(new Point(i - 1, j));
					}
				} else {
					if (map[i][j] == map[i + 1][j]) {
						del.add(new Point(i, j));
						del.add(new Point(i + 1, j));
					}
					if (map[i][j] == map[i - 1][j]) {
						del.add(new Point(i, j));
						del.add(new Point(i - 1, j));
					}
				}
			}
		}
		if (del.size() == 0)
			return false;
		for (Point p : del) {
			map[p.y][p.x] = 0;
		}
		return true;
	}

	static void avg() {
		double sum = 0;
		double cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0)
					cnt++;
				sum += map[i][j];
			}
		}
		double avg = sum / cnt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;
				if ((double) map[i][j] > avg)
					map[i][j] = map[i][j] - 1;
				else if ((double) map[i][j] < avg)
					map[i][j] = map[i][j] + 1;
			}
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

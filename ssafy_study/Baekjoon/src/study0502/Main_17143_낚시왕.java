package study0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {

	static int R, C, M, ans;
	static Shark[] info;
	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		info = new Shark[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			info[i] = new Shark(r, c, s, d, z);
		}
		fishing();
		System.out.println(ans);
	}

	static void fishing() {
		int col = 0;
		while (col < C) {
			col++;
			int min = Integer.MAX_VALUE;
			int eat = 0;
			for (int i = 0; i < M; i++) {
				if (info[i] == null)
					continue;
				if (info[i].c == col) {
					if (info[i].r < min) {
						min = info[i].r;
						eat = i;
					}
				}
			}
			if (min != Integer.MAX_VALUE) {
				ans += info[eat].z;
				info[eat] = null;
			}
			Shark[][] size = new Shark[R + 1][C + 1];
			for (int i = 0; i < M; i++) {
				if (info[i] == null)
					continue;
				Shark cur = info[i];
				if (cur.d == 1 || cur.d == 2) {
					int move = cur.r + dy[cur.d] * cur.s;
					while (move > R || move < 1) {
						if (move > R) {
							move = R - (move - R);
							cur.d = 1;
						} else if (move < 1) {
							move = 1 + (1 - move);
							cur.d = 2;
						}
					}
					cur.r = move;
				} else {
					int move = cur.c + dx[cur.d] * cur.s;
					while (move > C || move < 1) {
						if (move > C) {
							move = C - (move - C);
							cur.d = 4;
						} else if (move < 1) {
							move = 1 + (1 - move);
							cur.d = 3;
						}
					}
					cur.c = move;
				}
				if (size[cur.r][cur.c] == null)
					size[cur.r][cur.c] = new Shark(i, cur.z);
				else {
					if (cur.z < size[cur.r][cur.c].z)
						info[i] = null;
					else {
						info[size[cur.r][cur.c].n] = null;
						size[cur.r][cur.c] = new Shark(i, cur.z);
					}
				}
			}
		}
	}

	static class Shark {
		int r, c, s, d, z;
		int n;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		public Shark(int n, int z) {
			this.n = n;
			this.z = z;
		}
	}
}

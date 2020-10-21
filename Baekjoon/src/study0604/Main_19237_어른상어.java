package study0604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_19237_어른상어 {

	static int N, M, k;
	static int[][] map, mmap;
	static Shark[][] info;
	static int[][][] pd;
	static Shark[] shark;
	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		info = new Shark[N][N];
		shark = new Shark[M + 1];
		pd = new int[M + 1][5][5];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num != 0) {
					shark[num] = new Shark(i, j, 0);
					map[i][j] = num;
					info[i][j] = new Shark(i, j, num, k);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			shark[i].d = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= 4; k++) {
					pd[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		// 입력
		int cnt = 0;
		while (true) {
			move();
			cnt++;
			if (cnt > 1000) {
				cnt = -1;
				break;
			}
			if (check())
				break;
		}
		System.out.println(cnt);

	}

	static boolean check() {
		for (int i = 2; i < M + 1; i++) {
			if (shark[i] != null) {
				return false;
			}
		}
		return true;
	}

	static void move() {
		mmap = new int[N][N];
		List<Shark> ninfo = new LinkedList<>();
		for (int s = 1; s < M + 1; s++) {
			if(shark[s]==null)
				continue;
			Shark cur = shark[s];
			boolean allsm = false;
			for (int d = 1; d <= 4; d++) {
				int cpd = pd[s][cur.d][d]; // 현재 우선순위 d순위 방향
				int ny = cur.y + dy[cpd];
				int nx = cur.x + dx[cpd];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
					if (d == 4){
						allsm = true;
						d = 0;
					}
					continue;
				}
				if (!allsm) {
					if (info[ny][nx] == null) { // 비어있으면
						if (mmap[ny][nx] != 0) {
							shark[s] = null;
							break;
						}
						cur.y = ny;
						cur.x = nx;
						cur.d = cpd;
						mmap[ny][nx] = s;
						ninfo.add(new Shark(ny, nx, s, k));
						break;
					} else { // 안비어있는데
						if (d == 4) { // 마지막 우선순위까지 안비어있으면 모두 차있다. 자기 냄새칸으로 가자
							allsm = true;
							d = 0;
						}
					}
				} else {
					if (info[ny][nx].n == s) { // 자기냄새이면
						if (mmap[ny][nx] != 0) {
							shark[s] = null;
							break;
						}
						cur.y = ny;
						cur.x = nx;
						cur.d = cpd;
						mmap[ny][nx] = s;
						ninfo.add(new Shark(ny, nx, s, k));
						break;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (info[i][j] != null) {
					info[i][j].t--;
					if (info[i][j].t == 0)
						info[i][j] = null;
				}
			}
		}
		for (Shark s : ninfo) {
			info[s.y][s.x] = s;
		}
		for (int i = 0; i < N; i++) {
			System.arraycopy(mmap[i], 0, map[i], 0, N);
		}
	}

	static class Shark {
		int y, x, d;
		int n, t;

		public Shark(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}

		public Shark(int y, int x, int n, int t) {
			this.y = y;
			this.x = x;
			this.n = n;
			this.t = t;
		}
	}

}

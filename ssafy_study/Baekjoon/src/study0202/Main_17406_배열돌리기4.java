package study0202;

import java.util.Scanner;

public class Main_17406_배열돌리기4 {

	static int N, M, K, min;
	static int[][] map;
	static Rotate[] ro;
	static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ro = new Rotate[K];
		sel = new int[K];
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			ro[i] = new Rotate(r, c, s);
		}
		min = Integer.MAX_VALUE;
		perm(0,0);
		System.out.println(min);

	}

	public static void perm(int flag, int cnt) {
		if (cnt == K) {
			rotation(sel, map);
			return;
		}
		for (int i = 0; i < K; i++) {
			if ((flag & 1 << i) == 0) {
				sel[cnt] = i;
				perm(flag | 1 << i, cnt + 1);
			}
		}
	}

	public static void rotation(int[] sel, int[][] a) {
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, arr[i], 0, M);
		}
		for (int k = 0; k < K; k++) {
			int r = ro[sel[k]].r;
			int c = ro[sel[k]].c;
			int s = ro[sel[k]].s;

			int sy = r - s - 1; // 1
			int sx = c - s - 1; // 2
			int fy = r + s - 1; // 5
			int fx = c + s - 1; // 6
			int fin = ((fx + 1) - (sx + 1)) / 2;
			for (int n = 0; n < fin; n++) {
				int temp = arr[sy][fx];
				for (int i = fx; i > sx; i--) {
					arr[sy][i] = arr[sy][i - 1];
				}

				int temp2 = arr[fy][fx];
				for (int i = fy; i > sy + 1; i--) {
					arr[i][fx] = arr[i - 1][fx];
				}
				arr[sy + 1][fx] = temp;

				int temp3 = arr[fy][sx];
				for (int i = sx; i < fx - 1; i++) {
					arr[fy][i] = arr[fy][i + 1];
				}
				arr[fy][fx - 1] = temp2;

				for (int i = sy; i < fy - 1; i++) {
					arr[i][sx] = arr[i + 1][sx];
				}
				arr[fy - 1][sx] = temp3;

				sy += 1;
				sx += 1;
				fy -= 1;
				fx -= 1;
			}

		}
		arrayValue(arr);
	}
	
	public static void arrayValue(int[][] a){
		int arrmin = Integer.MAX_VALUE;
		for(int i=0;i<N;i++){
			int sum = 0;
			for(int j=0;j<M;j++){
				sum +=a[i][j];
			}
			arrmin = Math.min(arrmin, sum);
		}
		min = Math.min(min, arrmin);
	}

	static class Rotate {
		int r, c, s;

		public Rotate(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

}

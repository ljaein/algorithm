package study0201;

import java.util.Scanner;

public class Solution_D5_1247_최적경로 {

	static int T, N;
	static int[] cusx, cusy, sel;
	static int hx, hy, cx, cy;
	static int res, min;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			cusx = new int[N];
			cusy = new int[N];
			sel = new int[N];

			cx = sc.nextInt();
			cy = sc.nextInt();
			hx = sc.nextInt();
			hy = sc.nextInt();

			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				cusx[i] = sc.nextInt();
				cusy[i] = sc.nextInt();
			}
			perm(0, 0);
			System.out.println("#" + t + " " + min);

		}
	}

	public static void perm(int flag, int cnt) {
		if (cnt == N) {
			cal(sel);
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0) {
				sel[cnt] = i;
				perm(flag | 1 << i, cnt + 1);
			}
		}
	}

	public static void cal(int[] arr) {
		int cton = Math.abs(cx - cusx[arr[0]]) + Math.abs(cy - cusy[arr[0]]);
		int nton = 0;
		for (int i = 0; i < N - 1; i++) {
			nton += Math.abs(cusx[arr[i]] - cusx[arr[i + 1]]) + Math.abs(cusy[arr[i]] - cusy[arr[i + 1]]);
		}
		int ntoh = Math.abs(cusx[arr[N - 1]] - hx) + Math.abs(cusy[arr[N - 1]] - hy);
		res = cton + nton + ntoh;
		if (min > res) {
			min = res;
		}
	}

}

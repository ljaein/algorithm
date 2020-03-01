package study0204;

import java.util.Scanner;

public class Solution_모의_2112_보호필름 {

	static int T, D, W, K, res;
	static int[][] f_film, film;
	static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			res = Integer.MAX_VALUE;
			f_film = new int[D][W];
			film = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					f_film[i][j] = sc.nextInt();
				}
			}
			if (K == 1)
				res = 0;
			else if (check(f_film))
				res = 0;
			else {
				for (int i = 1; i <= K; i++) {
					sel = new int[i];
					combi(0, 0, i);
				}
			}
			System.out.println("#" + t + " " + res);

		}
	}

	public static void combi(int start, int cnt, int r) {
		if (cnt == r) {
			for (int i = 0; i < D; i++)
				System.arraycopy(f_film[i], 0, film[i], 0, W);

			// 모든 경우로 A,B 바꾸기//
			change(0, 0, r);
			change(0, 1, r);

			return;
		}
		for (int i = start; i < D; i++) {
			sel[cnt] = i;
			combi(i + 1, cnt + 1, r);
		}

	}

	public static void change(int idx, int c, int r) {
		if (idx == r) {
			if (check(film)) {
				res = Math.min(res, r);
				// 재귀 빠져나오기//
			}
			return;
		}
		for (int j = 0; j < W; j++) {
			film[sel[idx]][j] = c;
		}
		change(idx + 1, 0,r);
		change(idx + 1, 1,r);

	}

	public static boolean check(int[][] f) {
		for (int j = 0; j < W; j++) {
			boolean chk = false;
			int cnt = 0;
			for (int i = 0; i < D - 1; i++) {
				if (f[i][j] == f[i + 1][j]) {
					cnt++;
					if (cnt == K - 1) {
						chk = true;
						break;
					}
				} else
					cnt = 0;
			}
			if (!chk)
				return false;
		}
		return true;
	}

}

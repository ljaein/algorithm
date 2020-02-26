package study0204;

import java.util.Scanner;

public class Main_2630_색종이만들기 {

	static int N, wcnt, bcnt;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		divide(0, 0, N);
		System.out.println(wcnt);
		System.out.println(bcnt);

	}

	public static void divide(int y, int x, int n) {
		boolean diff = false;
		int cur = map[y][x];
		f: for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (cur != map[i][j]) {
					diff = true;
					break f;
				}
			}
		}
		if (diff) {
			divide(y, x, n / 2);
			divide(y, x + n / 2, n / 2);
			divide(y + n / 2, x, n / 2);
			divide(y + n / 2, x + n / 2, n / 2);
		} else {
			if (cur == 0)
				wcnt++;
			else
				bcnt++;
		}

	}

}

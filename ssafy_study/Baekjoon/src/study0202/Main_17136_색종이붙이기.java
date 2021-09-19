package study0202;

import java.util.Scanner;

public class Main_17136_색종이붙이기 {

	static int[][] paper;
	static int min = Integer.MAX_VALUE;
	static int[] sak = { 5, 5, 5, 5, 5 };

	public static void dfs(int y, int x, int cnt) {
		if (x == 10) {
			x = 0;
			y++;
		}
		if (y == 10) {
			if (min > cnt)
				min = cnt;
			return;
		}
		if (paper[y][x] == 1) {
			for (int s = 4; s >= 0; s--) {
				if (sak[s] != 0) {
					if (find(s, y, x)) {
						sak[s]--;
						fill(s, y, x, 0);
						dfs(y, x + 1, cnt + 1);
						fill(s, y, x, 1);
						sak[s]++;
					}
				}
			}
		} else {
			x++;
			if (x == 10) {
				x = 0;
				y++;
			}
			dfs(y, x, cnt);
		}
	}

	public static void fill(int s, int y, int x, int c) {
		for (int i = y; i < y + s + 1; i++) {
			for (int j = x; j < x + s + 1; j++) {
				if (i < 0 || j < 0 || i >= 10 || j >= 10)
					return;
				paper[i][j] = c;

			}
		}
	}

	public static boolean find(int s, int y, int x) {
		for (int i = y; i < y + s + 1; i++) {
			for (int j = x; j < x + s + 1; j++) {
				if (i < 0 || j < 0 || i >= 10 || j >= 10)
					return false;
				if (paper[i][j] != 1) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		paper = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0, 0);
		
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}

}
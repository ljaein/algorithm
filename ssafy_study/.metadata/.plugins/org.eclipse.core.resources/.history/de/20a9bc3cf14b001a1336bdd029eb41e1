package study0202;

import java.util.Scanner;

public class Solution_D3_1873_상호의배틀필드 {

	static int T, H, W, N, d, y, x;
	static char[][] map;
	static char[] order;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static char[] car = { '^', '>', 'v', '<' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '<') {
						d = 3;
						y = i;
						x = j;
					} else if (map[i][j] == '^') {
						d = 0;
						y = i;
						x = j;
					} else if (map[i][j] == '>') {
						d = 1;
						y = i;
						x = j;
					} else if (map[i][j] == 'v') {
						d = 2;
						y = i;
						x = j;
					}
				}
			}
			N = sc.nextInt();
			order = sc.next().toCharArray();
			for (int i = 0; i < N; i++) {
				char ord = order[i];
				if (ord == 'U') {
					d = 0;
					move();
				} else if (ord == 'D') {
					d = 2;
					move();
				} else if (ord == 'L') {
					d = 3;
					move();
				} else if (ord == 'R') {
					d = 1;
					move();
				} else if (ord == 'S')
					shoot();
			}
			System.out.print("#"+t+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	public static void move() {
		map[y][x] = car[d];
		int ny = y + dy[d];
		int nx = x + dx[d];
		if (ny < 0 || nx < 0 || ny >= H || nx >= W)
			return;
		if (map[ny][nx] == '.') {
			map[y][x] = '.';
			map[ny][nx] = car[d];
			y = ny;
			x = nx;
		}

	}

	public static void shoot() {
		int ny = y;
		int nx = x;
		while (true) {
			ny += dy[d];
			nx += dx[d];
			if (ny < 0 || nx < 0 || ny >= H || nx >= W)
				break;
			if (map[ny][nx] == '*') {
				map[ny][nx] = '.';
				break;
			} else if (map[ny][nx] == '#') {
				break;
			}
		}
	}

}

package study0301;

import java.util.Scanner;

public class Main_14499_주사위굴리기 {

	static int N, M, y, x, K;
	static int[][] map;
	static int[] go;
	static int[] dice = new int[6];
	static int[] dy = { 0, 0, 0, -1, 1 };
	static int[] dx = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		y = sc.nextInt();
		x = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		go = new int[K];
		for (int i = 0; i < K; i++)
			go[i] = sc.nextInt();
		copyNum();
	}

	static void copyNum() {
		for (int k = 0; k < K; k++) {
			int d = go[k];
			y += dy[d];
			x += dx[d];
			if (y < 0 || x < 0 || y >= N || x >= M) {
				y -= dy[d];
				x -= dx[d];
				continue;
			}
			rotate(d);
			if (map[y][x] == 0) {
				map[y][x] = dice[5];
			} else {
				dice[5] = map[y][x];
				map[y][x] = 0;
			}
			System.out.println(dice[0]);
		}
	}

	static void rotate(int d) {
		int n = 0;
		if (d == 1)
			n = 2;
		else if (d == 2)
			n = 3;
		else if (d == 3)
			n = 1;
		else
			n = 4;
		int temp = dice[n];
		dice[n] = dice[0];
		int temp2 = dice[5];
		dice[5] = temp;
		temp = dice[5 - n];
		dice[5 - n] = temp2;
		dice[0] = temp;
	}

}

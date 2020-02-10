package study0201;

import java.util.Scanner;

public class Main_2567_색종이2 {

	static int N, cnt;
	static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		map = new int[102][102];
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int a = y; a < y + 10; a++) {
				for (int b = x; b < x + 10; b++) {
					map[a][b] = 1;
				}
			}

		}

		int dy[] = { -1, 0, 1, 0 };
		int dx[] = { 0, 1, 0, -1 };
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if (map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (map[ny][nx] == 0) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

}

package study0203;

import java.util.Scanner;

public class Main_4963_섬의개수 {

	static int W, H, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();
			cnt = 0;
			if (W == 0 && H == 0)
				break;
			map = new int[H][W];
			visited = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);

		}
	}

	public static void dfs(int y, int x) {
		for (int d = 0; d < 8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= H || nx >= W || visited[ny][nx])
				continue;
			if (map[ny][nx] == 1) {
				visited[ny][nx] = true;
				dfs(ny, nx);
			}
		}
	}

}

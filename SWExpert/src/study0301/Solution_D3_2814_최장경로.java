package study0301;

import java.util.Scanner;

public class Solution_D3_2814_최장경로 {

	static int T, N, M, max;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N];
			max = 0;
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a - 1][b - 1] = 1;
				map[b - 1][a - 1] = 1;
			}
			for (int i = 0; i < N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			System.out.println("#" + t + " " + max);
		}
	}

	public static void dfs(int v, int cnt) {
		max = Math.max(max, cnt);
		for (int i = 0; i < N; i++) {
			if (map[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1);
				visited[i] = false;
			}
		}
	}

}

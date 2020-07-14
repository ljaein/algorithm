package study0703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {

	static int[][] map;
	static int K;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int[4][8];
		for (int i = 0; i < 4; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			visit = new boolean[4];
			rotate(num, dir);
		}
		int ans = 0;
		int score = 1;
		for (int i = 0; i < 4; i++) {
			if (map[i][0] == 1)
				ans += score;
			score *= 2;
		}
		System.out.println(ans);
	}

	static void rotate(int num, int dir) {
		visit[num] = true;
		int left = map[num][6];
		int right = map[num][2]; // 회전하기 전 좌우 극
		if (dir == 1) { // 시계 회전
			int temp = map[num][7];
			for (int i = 7; i >= 1; i--) {
				map[num][i] = map[num][i - 1];
			}
			map[num][0] = temp;
		} else { // 반시계 회전
			int temp = map[num][0];
			for (int i = 0; i <= 6; i++) {
				map[num][i] = map[num][i + 1];
			}
			map[num][7] = temp;
		}
		if (num - 1 >= 0 && left != map[num - 1][2] && !visit[num - 1])
			rotate(num - 1, dir == 1 ? -1 : 1);
		if (num + 1 < 4 && right != map[num + 1][6] && !visit[num + 1])
			rotate(num + 1, dir == 1 ? -1 : 1);

	}
}

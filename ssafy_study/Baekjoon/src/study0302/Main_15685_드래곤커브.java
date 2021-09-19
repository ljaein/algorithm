package study0302;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_15685_드래곤커브 {

	static int N, x, y, d, g, ans;
	static int[][] map;
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[101][101];
		for (int i = 0; i < N; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			d = sc.nextInt();
			g = sc.nextInt();
			curve(y, x, d, g);
		}
		
		System.out.println(square());

	}

	static void curve(int y, int x, int d, int g) {
		map[y][x] = 1;
		y += dy[d];
		x += dx[d];
		map[y][x] = 1;
		List<Integer> list = new LinkedList<>();
		list.add(d);
		for (int i = 0; i < g; i++) {
			List<Integer> newlist = new LinkedList<>();
			for (int j = list.size() - 1; j >= 0; j--) {
				int nd = list.get(j) == 3 ? 0 : (list.get(j) + 1);
				y += dy[nd];
				x += dx[nd];
				if (y >= 0 && x >= 0 && y < 101 && x < 101)
					map[y][x] = 1;
				newlist.add(nd);
			}
			list.addAll(newlist);
		}
	}

	static int square() {
		int[] dy = { 1, 0, 1 };
		int[] dx = { 0, 1, 1 };
		boolean check = false;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 3; k++) {
						if (map[i + dy[k]][j + dx[k]] == 1)
							continue;
						else{
							check = true;
							break;
						}
					}
					if (!check)
						ans++;
					check = false;
				}
			}
		}
		return ans;
	}
}

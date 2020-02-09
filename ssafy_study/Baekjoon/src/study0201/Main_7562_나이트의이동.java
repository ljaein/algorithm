package study0201;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7562_나이트의이동 {

	static int T, I;
	static int cy, cx, ay, ax, cnt;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			I = sc.nextInt();
			cy = sc.nextInt();
			cx = sc.nextInt();
			ay = sc.nextInt();
			ax = sc.nextInt();
			cnt = 1;
			map = new int[I][I];
			visited = new boolean[I][I];
			int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
			int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
			boolean find = false;
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(cy, cx));
			visited[cy][cx]=true;
			int num = 1;
			w: while (!q.isEmpty()) {
				int qsize = q.size();
				for (int s = 0; s < qsize; s++) {
					Point p = q.poll();
					//visited[p.y][p.x] = true;

					for (int i = 0; i < 8; i++) {
						int ny = p.y + dy[i];
						int nx = p.x + dx[i];
						if (ny < 0 || nx < 0 || ny >= I || nx >= I)
							continue;
						if (visited[ny][nx])
							continue;
						if (ny == ay && nx == ax) {
							find = true;
							System.out.println(cnt);
							break w;
						}
						q.add(new Point(ny, nx));
						visited[ny][nx]=true; //********************************************* 넣을때마다 방문 표시
					}
				}
				cnt++;
			}
			if(!find){
				System.out.println(0);
			}

		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
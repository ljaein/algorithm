package study0401;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_2174_로봇시뮬레이션 {

	static int A, B, N, M;
	static boolean flag;
	static List<Point> list;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[B][A];
		flag = false;
		list = new LinkedList<>();
		int num = 1;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			char c = sc.next().charAt(0);
			int dir = 0;
			if (c == 'S')
				dir = 0;
			else if (c == 'E')
				dir = 1;
			else if (c == 'N')
				dir = 2;
			else
				dir = 3;
			Point robot = new Point(y, x, dir);
			list.add(robot);
			map[y][x] = num;
			num++;
		}
		
		for (int i = 0; i < M; i++) {
			int n = sc.nextInt() - 1;
			char order = sc.next().charAt(0);
			int cnt = sc.nextInt();
			move(n, order, cnt);
//			for(int a=0;a<B;a++){
//				for(int j=0;j<A;j++){
//					System.out.print(map[a][j]+" ");
//				}
//				System.out.println();
//			}
			if(flag)
				break;
		}
		if (!flag)
			System.out.println("OK");

	}

	static void move(int n, int order, int cnt) {
		Point cur = list.get(n);
		int ny = cur.y;
		int nx = cur.x;
		if (order == 'F') {
			for (int i = 0; i < cnt; i++) {
				ny += dy[cur.dir];
				nx += dx[cur.dir];
				if (ny < 0 || nx < 0 || ny >= B || nx >= A) {
					flag = true;
					System.out.println("Robot " + (n + 1) + " crashes into the wall");
					return;
				}
				if (map[ny][nx] != 0) {
					flag = true;
					System.out.println("Robot " + (n + 1) + " crashes into robot " + map[ny][nx]);
					return;
				}
			}
			map[cur.y][cur.x] = 0;
			//System.out.println(ny+" "+nx);
			map[ny][nx] = n+1;
			//System.out.println(map[ny][nx]);
			list.get(n).y = ny;
			list.get(n).x = nx;

		} else if (order == 'R') {
			for (int i = 0; i < cnt; i++) {
				cur.dir = (cur.dir == 0 ? 3 : cur.dir - 1);
			}
		} else {
			for(int i=0;i<cnt;i++){
				cur.dir = (cur.dir == 3 ? 0 : cur.dir + 1);				
			}
		}
	}

	static class Point {
		int y, x, dir;

		public Point(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

	}

}

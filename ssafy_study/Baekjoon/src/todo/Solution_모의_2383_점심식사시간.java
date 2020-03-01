package todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_모의_2383_점심식사시간 {

	static int T, N, time, arrp, min;
	static int[][] map;
	static Point[] fixA, fixB;
	static Point[] stairs;
	static ArrayList<Point> peo;
	static ArrayList<Integer> As, Bs;
	static Queue<Point> Aq, Bq;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			stairs = new Point[2];
			peo = new ArrayList<>();
			
			min=Integer.MAX_VALUE;
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] != 1 && map[i][j] != 0) {
						stairs[idx++] = new Point(i, j);
					} else if (map[i][j] == 1) {
						peo.add(new Point(i, j));
					}
				}
			}
			for (int i = 0; i < peo.size(); i++) {
				fixA = new Point[i];
				fixB = new Point[peo.size() - i];
				boolean[] check = new boolean[peo.size()];
				combi(0, 0, i, check);
			}

			System.out.println("결과"+min);
		}
	}

	public static void combi(int start, int cnt, int r, boolean[] check) {
		if (cnt == r) {
			int idx = 0;
			for (int i = 0; i < peo.size(); i++) {
				if (!check[i])
					fixB[idx++] = peo.get(i);
			}
			time = 0;
			arrp = 0;
			As = new ArrayList<>();
			Aq = new LinkedList<>();
			Bs = new ArrayList<>();
			Bq = new LinkedList<>();
			Point[] A = new Point[r];
			Point[] B = new Point[peo.size()-r];
			System.arraycopy(fixA, 0, A, 0, r);
			System.arraycopy(fixB, 0, B, 0, peo.size()-r);
			while (arrp < peo.size()) {
				time++;
				minute(A, 0, As, Aq);
				minute(B, 1, Bs, Bq);
				System.out.println("=========="+time+"===========");
			}
		
		//	if(min>time+1)
				System.out.println(Arrays.toString(check));
				System.out.println(time+1);
			//min = Math.min(min, time+1);
			return;
		}
		for (int i = start; i < peo.size(); i++) {
			fixA[cnt] = peo.get(i);
			check[i] = true;
			combi(i + 1, cnt + 1, r, check);
			check[i] = false;
		}
	}

	public static void minute(Point[] P, int snum, ArrayList<Integer> list, Queue<Point> q) {
		System.out.println(snum+": "+"z큐"+q.size()+" 리스트"+list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			list.set(i, list.get(i) + 1);
			if (list.get(i) == map[stairs[snum].y][stairs[snum].x]) {
				list.remove(i);
				System.out.println("아예도착");
				arrp++;
			}
		}
		if (!q.isEmpty() && list.size() < 3) {
			q.poll();
			list.add(0);
		}
		for (int i = 0; i < P.length; i++) {
			if (P[i].y == -1)
				continue;
			System.out.println(P[i].y+" "+P[i].x);
			if (P[i].y < stairs[snum].y) {
				P[i].y += 1;
			} else if (P[i].y > stairs[snum].y) {
				P[i].y -= 1;
			} else { // y좌표 같은 경우
				if (P[i].x < stairs[snum].x) {
					P[i].x += 1;
				} else if (P[i].x > stairs[snum].x) {
					P[i].x -= 1;
				} else {// x좌표 같은 경우
					P[i].y = -1;
					System.out.println("도착");
					if (list.size() < 3) {
						list.add(-1);
					} else {
						q.add(new Point(P[i].y, P[i].x));
					}

				}
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

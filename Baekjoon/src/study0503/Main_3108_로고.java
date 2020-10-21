package study0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3108_로고 {

	static int N, cnt;
	static Rec[] rec;
	static boolean[] visit;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		rec = new Rec[N + 1];
		visit = new boolean[N + 1];
		rec[0] = new Rec(0, 0, 0, 0);
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			rec[i] = new Rec(x1, y1, x2, y2);
		}

		for (int i = 0; i <= N; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			q.add(i);

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (int j = 0; j <= N; j++) {
					if (cur == j || visit[j])
						continue;
					if (isCross(rec[cur], rec[j])) {
						visit[j] = true;
						q.add(j);
					}
				}
			}
			cnt++;

		}
		System.out.println(cnt - 1);
	}

	static boolean isCross(Rec a, Rec b) {
		if (a.x1 < b.x1 && b.x2 < a.x2 && a.y1 < b.y1 && b.y2 < a.y2)
			return false;
		if (a.x1 > b.x1 && b.x2 > a.x2 && a.y1 > b.y1 && b.y2 > a.y2)
			return false;
		if (a.x2 < b.x1 || a.x1 > b.x2 || a.y2 < b.y1 || a.y1 > b.y2)
			return false;
		return true;
	}

	static class Rec {
		int x1, y1, x2, y2;

		public Rec(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

	}

}

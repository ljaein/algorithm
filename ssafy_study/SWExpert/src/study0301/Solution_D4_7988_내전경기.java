package study0301;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_7988_내전경기 {

	static int T, K, pnum;
	static HashMap<String, Integer> name;
	static boolean[][] map;
	static int[] team;
	static boolean ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			K = sc.nextInt();
			name = new HashMap<>();
			map = new boolean[K * 2][K * 2];
			ans = true;
			pnum = 0;
			for (int i = 0; i < K; i++) {
				String s1 = sc.next();
				String s2 = sc.next();
				if (!name.containsKey(s1))
					name.put(s1, pnum++);
				if (!name.containsKey(s2))
					name.put(s2, pnum++);
				map[name.get(s1)][name.get(s2)] = true;
				map[name.get(s2)][name.get(s1)] = true;
			}
			team = new int[pnum];
			for (int i = 0; i < pnum; i++) {
				if (team[i] == 0) {
					team[i] = 1;
					bfs(i);
				}
				if (!ans)
					break;
			}
			System.out.println("#" + t + " " + (ans ? "YES" : "NO"));
		}
	}

	static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(idx);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < pnum; i++) {
				if (map[cur][i]) {
					if (team[cur] == team[i]) {
						ans = false;
						return;
					}
					if (team[i] == 0) {
						team[i] = team[cur] == 1 ? 2 : 1;
						q.add(i);
					}

				}
			}
		}
	}

}

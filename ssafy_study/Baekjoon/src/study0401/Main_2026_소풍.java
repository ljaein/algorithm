package study0401;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_2026_소풍 {

	static int K, N, F;
	static boolean find;
	static int[][] map;
	static int[] size;
	static boolean[] visit;
	static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		F = sc.nextInt();
		map = new int[N][N];
		size = new int[N];
		find = false;
		for (int i = 0; i < F; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			map[a][b] = 1;
			map[b][a] = 1;
			size[a]++;
			size[b]++;
		}
		for (int i = 0; i < N; i++) {
			if (size[i] + 1 < K)
				continue;
			visit = new boolean[N];
			list = new LinkedList<Integer>();
			go(i);
			if(find)
				break;
		}
		if(!find)
			System.out.println(-1);

	}

	static void go(int v) {
		if(find)
			return;
		visit[v] = true;
		list.add(v);
		if (list.size() == K) {
			find = true;
			for(int i=0;i<K;i++)
				System.out.println(list.get(i)+1);
			return;
		}
		for (int i = v + 1; i < N; i++) {
			if (!visit[i]) {
				boolean chk = true;
				for (int ver : list) {
					if (map[i][ver] == 0) {
						chk = false;
						break;
					}
				}
				if (chk) 
					go(i);
			}
		}
	}

}

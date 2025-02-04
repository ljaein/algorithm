package study0201;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_DFS와BFS {

	static int N, M, V, idx;
	static int[][] map;
	static boolean[] visited;
	static int[] res;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		res = new int[N];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		visited[V] = true;
		res[idx++] = V;
		System.out.print(V + " ");
		DFS(V);
		System.out.println();
		BFS();

	}

	public static void DFS(int v) {
		for (int i = 1; i < N + 1; i++) {
			if (map[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				System.out.print(i + " ");
				DFS(i);
			}
		}
	}

	public static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N + 1];
		System.out.print(V + " ");
		q.add(V);
		visited[V] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i < N + 1; i++) {
				if (map[cur][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
					System.out.print(i + " ");
				}
			}
		}
	}
	
}

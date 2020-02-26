package study0204;

import java.util.Arrays;
import java.util.Scanner;

public class Main_17471_게리맨더링 {

	static int N, min;
	static int[] P;
	static int[] A, B;
//	static int[] A ={0,3};
//	static int[] B={1,2,4,5};
	static boolean[] visited;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		P = new int[N];
		map = new int[N][N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				int c = sc.nextInt();
				map[i][c - 1] = 1;
			}
		}
		for (int i = 1; i < N; i++) {
			A = new int[i];
			B = new int[N - i];
			boolean[] check = new boolean[N];
			combi(0, 0, i, check);
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);

	}

	public static void combi(int start, int cnt, int r, boolean[] check) {
		if (cnt == r) {
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!check[i]) {
					B[idx++] = i;
				}
			}
			visited = new boolean[N];
			link(A, A[0]);
			boolean Ac = check(A);
			visited = new boolean[N];
			link(B, B[0]);
			boolean Bc = check(B);
			if (Ac && Bc) {
				min = Math.min(min, people());
			}
			return;
		}
		for (int i = start; i < N; i++) {
			A[cnt] = i;
			check[i] = true;
			combi(i + 1, cnt + 1, r, check);
			check[i] = false;
		}
	}

	public static void link(int[] arr, int i) {
		visited[i] = true;
		for (int j = 0; j < arr.length; j++) {
			if (map[i][arr[j]] == 1 && !visited[arr[j]]) {
				visited[arr[j]] = true;
				link(arr, arr[j]);
			}
		}
	}

	public static boolean check(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (!visited[arr[i]])
				return false;
		}
		return true;
	}

	public static int people() {
		int Ap = 0;
		int Bp = 0;
		for (int i = 0; i < A.length; i++) {
			Ap += P[A[i]];
		}
		for (int i = 0; i < B.length; i++) {
			Bp += P[B[i]];
		}
		return Math.abs(Ap - Bp);
	}

}

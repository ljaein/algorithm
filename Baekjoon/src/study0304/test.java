package study0304;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class test {

	static int N, M, ans;
	static List<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			int parent = sc.nextInt() - 1;
			if (parent != -1)
				list[parent].add(i);
		}

		for (int i = 0; i < M; i++) {
			int cnt = 0;
			int ok = sc.nextInt() - 1;
			int no = sc.nextInt() - 1;
			Queue<Integer> q = new LinkedList<>();
			q.add(ok);
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int num : list[cur]) {
					cnt++;
					if (num != no) {
						q.add(num);
					}
				}
			}
			ans += cnt;
		}
		System.out.println(ans);
	}

}

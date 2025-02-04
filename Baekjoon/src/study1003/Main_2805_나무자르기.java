package study1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
	static int N, M;
	static long max;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		System.out.println(search());

	}

	static long search() {
		long s = 0;
		long e = max;
		while (s <= e) {
			long mid = (s + e) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				long len = tree[i] - mid;
				if (len > 0) {
					sum += len;
				}
			}
			if (sum == M) {
				s = mid + 1;
			} else if (sum < M) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		return e;
	}

}

package study1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_공유기설치 {

	static int N, C;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		System.out.println(search());
	}

	static int search() {
		int s = 1;
		int e = arr[N - 1] - arr[0];
		while (s <= e) {
			int mid = (s + e) / 2;
			int cnt = 1;
			int start = 0;
			for (int i = start + 1; i < N; i++) {
				int dist = arr[i] - arr[start];
				if (dist >= mid) {
					cnt++;
					start = i;
				}
			}
			if (cnt == C) {
				s = mid + 1;
			} else if (cnt < C) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		return e;
	}

}

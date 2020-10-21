package study1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇 {

	static int N, K;
	static int[] belt;
	static boolean[] box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N];
		box = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int cnt = 0;
		while (cnt < K) {
			ans++;
			int temp = belt[2 * N - 1];
			for (int i = 2 * N - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
				if(i<N){
					box[i] = box[i - 1];
				}
			}
			belt[0] = temp; // 벨트 한칸 회전
//			for (int i = N - 1; i > 0; i--) {
//				box[i] = box[i - 1];
//			} // 박스도 한칸 회전
			box[0] = false;
			box[N - 1] = false; // 마지막꺼 내림
			for (int i = N - 2; i >= 0; i--) {
				if (box[i] && !box[i + 1] && belt[i + 1] >= 1) {
					box[i + 1] = true;
					box[i] = false;
					belt[i + 1]--;
					if (belt[i + 1] == 0)
						cnt++;
				}
			} // 박스 한칸씩 이동
			box[N - 1] = false; // 마지막꺼 내림
			if (!box[0] && belt[0] >= 1) {
				box[0] = true;
				belt[0]--;
				if (belt[0] == 0)
					cnt++;
			} // 첫번째에 없으면 올림
		}
		System.out.println(ans);

	}

}

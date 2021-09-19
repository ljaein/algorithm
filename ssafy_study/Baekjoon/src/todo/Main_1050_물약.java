package todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

//맵에 넣고 물약 돌면서 맵이 갱신되면 물약 처음부터 돈다.
public class Main_1050_물약 {

	static int N, M;
	static long ans;
	static HashMap<String, Long> map;
	static LinkedList<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			long value = Integer.parseInt(st.nextToken());
			map.put(key, value);
		}
		list = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			list.add(br.readLine());
		}
		boolean flag = true;
		while(flag) {
			flag = false;
			for (int i = 0; i < M; i++) {
				if (calc(list.get(i))) {
					flag = true;
				}
			}
		}
		if(map.containsKey("LOVE")){
			ans = map.get("LOVE")>1000000000?1000000001:map.get("LOVE");
		}else{
			ans = -1;
		}
		System.out.println(ans);

	}

	static boolean calc(String s) {
		String[] sarr = s.split("=");
		String medi = sarr[0];
		String sik = sarr[1];
		String[] sum = sik.split("\\+");
		long num = 0;
		for (int i = 0; i < sum.length; i++) {
			long mul = sum[i].charAt(0) - '0';
			String mat = sum[i].substring(1);
			if (map.containsKey(mat)) {
				num += mul * map.get(mat);
			} else {
				return false;
			}
		}
		if (map.containsKey(medi) && map.get(medi) <= num) {
			return false;
		} else {
			map.put(medi, num);
			return true;
		}
	}

}

package study_2021_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003_수들의합 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = 0;
		int sum =0;
		int ans = 0;
		while(true){
			if(sum>M){
				sum -= arr[l];
				l += 1;
			}
			else if(r==N)
				break;
			else if(sum<=M){
				sum += arr[r];
				r += 1;
			}
			
			if(sum == M){
				ans++;
			}
		}
		System.out.println(ans);
	}

}

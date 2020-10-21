package study0304;

import java.util.Scanner;

public class Main_15651_N과M3 {

	static int N,M;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		sel = new int[M];
		Perm(0);
		System.out.println(sb.toString());
	}
	static void Perm(int cnt){
		if(cnt==M){
			for(int i=0;i<M;i++)
				sb.append(sel[i]).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++){
			sel[cnt]=i+1;
			Perm(cnt+1);
		}
	}

}

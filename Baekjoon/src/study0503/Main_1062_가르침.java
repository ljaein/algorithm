package study0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1062_가르침 {

	static int N,K,ans;
	static String[] word;
	static boolean[] alph = new boolean[26];
	static LinkedList<Character> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken())-5;
		if(K<0){
			System.out.println(0);
			return;
		}
		word = new String[N];
		list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			word[i] = s.substring(4,s.length()-4);
		}
		alph['a'-'a']=true;
		alph['n'-'a']=true;
		alph['t'-'a']=true;
		alph['i'-'a']=true;
		alph['c'-'a']=true;
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < word[i].length(); j++) {
				char c = word[i].charAt(j);
				if(alph[c-'a'])
					continue;
				set.add(c);
			}
		}
		list.addAll(set);
		if(list.size() <= K)
			ans = N;
		else
			combi(0,0);
		System.out.println(ans);
	}
	
	static void combi(int start, int cnt){
		if(cnt==K){
			ans = Math.max(ans, readCnt());
			return;
		}
		for(int i=start;i<list.size();i++){
			char c = list.get(i);
			alph[c-'a']=true;
			combi(i+1,cnt+1);
			alph[c-'a']=false;
		}		
	}
	
	static int readCnt(){
		int cnt = 0;
		for(int i=0;i<N;i++){
			boolean flag = true;
			for(int j=0;j<word[i].length();j++){
				if(!alph[word[i].charAt(j)-'a']){
					flag = false;
					break;
				}
			}
			if(flag)
				cnt++;
		}
		return cnt;
	}

}

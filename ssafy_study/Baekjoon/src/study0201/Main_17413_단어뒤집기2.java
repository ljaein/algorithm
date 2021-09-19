package study0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		
		StringBuffer sb = new StringBuffer();
		StringBuffer res= new StringBuffer();
		
		boolean galho = false;
		for(int i=0;i<str.length;i++){
			if(str[i]=='<'){
				if(sb.length()!=0){
					res.append(sb.reverse());
					sb = new StringBuffer();
				}
				res.append(str[i]);
				galho=true;
			}else if(str[i]=='>'){
				res.append(str[i]);
				galho=false;
			}else if(str[i]==' '){
				res.append(sb.reverse());
				res.append(" ");
				sb = new StringBuffer();
			}else{
				if(galho)
					res.append(str[i]);
				else
					sb.append(str[i]);
			}
		}
		if(sb.length()!=0){
			res.append(sb.reverse());
		}
		System.out.println(res);
		
	}

}

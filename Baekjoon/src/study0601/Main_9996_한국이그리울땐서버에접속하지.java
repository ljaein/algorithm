package study0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9996_한국이그리울땐서버에접속하지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] patt = s.split("\\*");
        String pre  = patt[0];
        String suf = patt[1];
		
        for(int i=0;i<N;i++){
			String name = br.readLine();
            if(name.startsWith(pre)){
            	name = name.substring(pre.length());
            	if(name.endsWith(suf)){
            		System.out.println("DA");
            	}else{
            		System.out.println("NE");
            	}
            }else{
            	System.out.println("NE");
            }
		}
	}

}

package study0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10988_팰린드롬인지확인하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String rever="";
        for(int i=s.length()-1;i>=0;i--){
            rever += s.substring(i,i+1);
        }
        if(s.equals(rever))
            System.out.println("1");
        else
            System.out.println("0");
    }
}

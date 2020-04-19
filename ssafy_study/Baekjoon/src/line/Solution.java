package line;

import java.util.Scanner;

public class Solution {

	static int ans;
	static int[] start, end;
	static char[] c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		start = new int[4];
		end = new int[4];
		c = sc.nextLine().toCharArray();
		calc();
		System.out.println(ans);

	}
	static void calc(){
		for(int i=0;i<c.length;i++){
			if(c[i]=='('){
				start[0]++;
			}else if(c[i]=='{'){
				start[1]++;
			}else if(c[i]=='['){
				System.out.println("in");
				start[2]++;
			}else if(c[i]=='<'){
				start[3]++;
			}else if(c[i]==')'){
				if(start[0]==0){
					ans = -1;
					return;
				}
				end[0]++;
			}else if(c[i]=='}'){
				if(start[1]==0){
					ans = -1;
					return;
				}
				end[1]++;
			}else if(c[i]==']'){
				if(start[2]==0){
					ans = -1;
					return;
				}
				end[2]++;
			}else if(c[i]=='>'){
				if(start[3]==0){
					ans = -1;
					return;
				}
				end[3]++;
			}
		}
		for(int i=0;i<4;i++){
			if(start[i]!=end[i]){
				ans = -1;
				break;
			}else{
				ans += start[i];
			}
		}
	}

}

package study0201;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class test {

	public static void main(String[] args) {
		int[] arr = new int[3];
		arr[2] = 1;
		abc(arr);
		System.out.println(arr[2]);
	}
	
	static void abc(int[] ar){
		ar[2]=2;
	}

}

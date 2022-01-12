package basic;

import java.util.Arrays;

public class Exercise_07 {
	
	static void copy(int[]a, int[]b) {
		for(int i=0;i<b.length;i++) {
			a[i]=b[i];
		}
			
	}
	static void rcopy(int[]a,int[]b) {
		for(int i=0;i<b.length;i++) {
			a[i]=b[b.length-i-1];
		}
		
	}
	
	
	public static void main(String[] args) {
		int[]p= {5,12,7,13,53,632,9};
		int[]p2 = new int[7];
		copy(p2,p);
		System.out.println(Arrays.toString(p2));
		rcopy(p2,p);
		System.out.println(Arrays.toString(p2));
	}

}

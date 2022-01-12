package search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//PhysExamSearch
public class BinSearchEx04 {
	static class PhyscData {
		private String name;
		private int height;
		private double vision;

		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		public String toString() {
			return name+" "+height+" "+vision;
		}
		public static final Comparator<PhyscData>VISION_ORDER =new VisionOrderComparator();
		
		private static class VisionOrderComparator  implements Comparator<PhyscData>{
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.vision>d2.vision)?1 :
					(d1.vision<d2.vision)?-1 : 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn=new Scanner(System.in);
		PhyscData[]x = {
				new PhyscData("이나령", 162, 0.1),
				new PhyscData("서영호", 168, 0.2),
				new PhyscData("김근형", 151, 0.4),
				new PhyscData("채상민", 164, 0.7),
				new PhyscData("안상욱", 186, 1.2),
				new PhyscData("류승범", 152, 1.3),
				new PhyscData("안철수", 190, 1.7)
		};
		System.out.print("찾는 시력은： ");
		double  vision   =stdIn.nextDouble();
		int idx=Arrays.binarySearch(
				x,
				new PhyscData("",0 ,vision),
				PhyscData.VISION_ORDER
				);
		
		if(idx<0) 
			System.out.println("data가 없습니다.");
		else {
			System.out.println("x["+idx+"]에 있습니다.");
			System.out.println("찾는 데이터: "+x[idx]);
		}

	}

}

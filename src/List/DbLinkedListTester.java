package List;

import java.util.Comparator;
import java.util.Scanner;

import List.LinkedListTester.Data;
import List.LinkedListTester.Menu;
//원형 이중리스트 사용
public class DbLinkedListTester {
	static Scanner circleList = new Scanner(System.in);

	//데이터 (회원번호+이름)
	
	static class Data{
		static final int NO =1;		//번호를 입력받습니까?
		static final int NAME =2;	//이름을 입력받습니까?
		
		private Integer no;			//회원 번호
		private String name;		//회원 이름
		
		//문자열을 반환합니다.
		
		public String toString() {
			return "("+no+")"+name;
		}
		//데이터를 입력합니다.
		void scanData(String guide,int sw) {
			System.out.println(guide+"할 데이터를 입력하세요.");
			
			if ((sw&NO)==NO) {
				System.out.println("번호: ");
				no=circleList.nextInt();
			}
			if ((sw&NAME)==NAME) {
				System.out.println("이름: ");
				name=circleList.next();
			}
		}
		//회원번호 순으로 순서를 매기는 comparator
		public static final Comparator<Data> NO_ORDER=new NoOrderComparator();
		private static class NoOrderComparator implements Comparator<Data>{
			public int compare(Data d1, Data d2) {
				return (d1.no>d2.no)?1:(d1.no<d2.no)?-1:0;
			}
		}
		//이름순으로 순서를 매기는 comparator
		public static final Comparator<Data> NAME_ORDER=new NoOrderComparator();
		private static class NameOrderComparator implements Comparator<Data>{
			public int compare(Data d1, Data d2) {
				return d1.name.compareTo(d2.name);
			}
		}
	}
	enum Menu {
		ADD_FIRST("head에 노드를 삽입"), 
		ADD_LAST("꼬리에 노드를 삽입"), 
		ADD("선택노드 바로 뒤에 삽입"), 
		RMV_FIRST("head에 노드를 삭제"), 
		RMV_LAST("꼬리에 노드를 삭제"),
		RMV_CRNT("선택 노드를 삭제"), 
		CLEAR("모든 노드를 삭제"), 
		SEARCH_NO("회원번호로 검색"),
		SEARCH_NAME("이름으로 검색"),
		NEXT("선택 노드를뒤쪽으로 이동"), 
		PREV("선택 노드를앞쪽으로 이동"), 
		PRINT_CRNT("선택노드를 출력"), 
		DUMP("모든 노드를 출력"), 
		TERMINATE("종료");
		
		

		private final String message;		//출력할 문자열
		
		static Menu MenuAt(int idx) {		//서수가 idx인 열거를 반환
			for(Menu m : Menu.values())
				if(m.ordinal()==idx)
					return m;
			return null;
		}
		
		
		Menu(String string) {				//생성자
			message=string;
		}
		
		String getMessage() {				//출력할 문자열을 반환
			return message;
		}
		
	}
	//메뉴 선택
			static Menu SelectMenu() {
				int key;
				do {
					for(Menu m: Menu.values()) {
						System.out.printf("(%d) %s ",m.ordinal(),m.getMessage()); //m.message() == "head에 노드를 삽입"
						if((m.ordinal()%3)==2&& m.ordinal()!=Menu.TERMINATE.ordinal()) //맨앞 향애  3개 남기고 3개씩 출력해라
							System.out.println();
					}
					System.out.print(" : ");
					key=circleList.nextInt();
				}while (key<Menu.ADD_FIRST.ordinal()||
									key>Menu.TERMINATE.ordinal());
				return Menu.MenuAt(key);
			}
	
	
	
	public static void main(String[] args) {
		Menu menu;				//메뉴
		Data data;				//추가용 데이터 참조
		Data ptr;				//검색용 데이터 참조
		Data temp=new Data();	//입력용 데이터
		
		DblLinkedList<Data> list =new DblLinkedList<Data>(); //리스트 생성
		
		do {
			switch(menu=SelectMenu()){
			
				case ADD_FIRST:				//머리에 노드를 삽입
					data=new Data();
					data.scanData("머리에 삽입", Data.NO|Data.NAME);
					list.addFirst(data);
					break;
					
				case ADD_LAST:				//꼬리에 노드를 삽입
					data=new Data();
					data.scanData("꼬리에 삽입", Data.NO|Data.NAME);
					list.addLast(data);
					break;
				case ADD:
					data=new Data();
					data.scanData("선택노드 바로 뒤에 삽입", Data.NO|Data.NAME);
					list.add(data);
				case RMV_FIRST:				//머리 노드를 삭제
					list.removeFirst();
					break;
				case RMV_LAST:				//꼬리 노드를 삭제
					list.removeLast();
					break;
				case RMV_CRNT:				//선택노드를 삭제
					list.removeCurrentNode();
					break;
				case SEARCH_NO:				//회원번호로 검색
					temp.scanData("검색", Data.NO);
					ptr=list.search(temp, Data.NO_ORDER);
					if(ptr==null)
						System.out.println("그 번호의 데이터가 없습니다.");
					else
						System.out.println("검색 성공: "+ptr);
					break;
				case SEARCH_NAME:			//이름으로 검색
					temp.scanData("검색", Data.NAME);
					ptr=list.search(temp, Data.NAME_ORDER);
					if(ptr==null)
						System.out.println("그 번호의 데이터가 없습니다.");
					else
						System.out.println("검색 성공: "+ptr);
					break;
				case NEXT:					//선택노드를 뒤쪽으로 이동
					list.next();
					break;
				case PREV:
					list.prev();
					break;
				case PRINT_CRNT:			//선택노드의 데이터를 출력
					list.printCurrentNode();
					break;
				case DUMP:
					list.dump();
					break;
					
				case CLEAR:					//모든노드를 삭제
					list.clear();
					break;
					
			}
		}while (menu!=Menu.TERMINATE);
	}
}

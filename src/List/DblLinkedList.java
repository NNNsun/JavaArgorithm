package List;
//원형 이중연결리스트
import java.util.Comparator;

public class DblLinkedList <E>{
	//노드
	class Node<E>{
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		//생성자
		Node(){
			data=null;
			prev=next=this;
		}
		//생성자
		Node(E obj, Node<E> prev, Node<E> next){
			data=obj;
			this.prev=prev;
			this.next=next;
		}
	}
	private Node<E> head;	// 헤드노드(더미노드)
	private Node<E> crnt;	// 선택노드
	
	//생성자
	public DblLinkedList() {
		head=crnt=new Node<E>(); //더미노드 생성
	}
	public boolean isEmpty() {
		return head.next==head;
	}
	//노드를 검색
	public E search(E obj, Comparator<? super E>c) {
		Node<E> ptr = head.next;	//현재 스캔중인 노드
		
		while (ptr!=head) {
			if(c.compare(obj, ptr.data)==0) {
				crnt=ptr;
				return ptr.data; //검색성공
			}
			ptr=ptr.next;		 //다음 노드로 선택
		}
		return null;			 //검색 실패
	}
	//선택 노드를 출력
	public void printCurrentNode() {
		if (isEmpty())
			System.out.println("선택노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}
	//모든 노드를 출력
	public void dump() {
		Node<E> ptr = head.next;		//더미 노드의 다음 노드
		
		while (ptr!=head) {
			System.out.println(ptr.data);
			ptr=ptr.next;
		}
	}
	//모든 노드를 거꾸로 출력
	public void dumpReverse() {
		Node<E>ptr=head.prev;			//더미 노드의 앞쪽 노드
		
		while (ptr !=head) {
			System.out.println(ptr.data);
			ptr=ptr.prev;
		}
	}
	//선태노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if(isEmpty()||crnt.next==head)
			return false;		//이동할 수 없음
		crnt=crnt.next;
		return true;
	}
	//선택노드를 하나 앞쪽으로 이동
	public boolean prev() {
		if(isEmpty()||crnt.prev==head)
			return false;		//이동할 수 없음
		crnt=crnt.prev;
		return true;
	}
	//선택노드의 바로 뒤쪽에 노드를 삽입
	public void add(E obj) {
		Node<E>node= new Node<E>(obj, crnt, crnt.next);
		crnt.next=crnt.next.prev=node;
		crnt=node;
	}
	//머리에 노드를 삽입
	public void addFirst(E obj) {
		crnt=head;			//더미노드 head의 바로 뒤에 삽입
		add(obj);
	}
	//꼬리에 노드를 삽입
	public void addLast(E obj) {
		crnt=head.prev;		//꼬리 노드 head.prev의 바로 뒤에 삽입
		add(obj);
	}
	//선택 노드를 삭제
	public void removeCurrentNode() {
		if(!isEmpty()) {
			crnt.prev.next=crnt.next;
			crnt.next.prev=crnt.prev;
			if(crnt==head)crnt=head.next;
		}
	}
	//노드 p를 삭제
	public void remove(Node p) {
		Node<E>ptr=head.next;
		
		while (ptr != head) {
			if(ptr==p) {
				crnt=p;
				removeCurrentNode();
				break;
			}
			ptr=ptr.next;
		}
	}
	//머리노드를 삭제
	public void removeFirst() {
		crnt=head.next;			//머리노드 head.next를 삭제
		removeCurrentNode();
	}
	
	//꼬리노드를 삭제
	public void removeLast() {
		crnt=head.prev;
		removeCurrentNode();
	}
	//모든 노드를 삭제
	public void clear() {
		while (!isEmpty())		//텅 빌때까지
			removeFirst();		//머리노드를 삭제
	}
	
}

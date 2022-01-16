package List;

import java.util.Comparator;

public class LinkedList<E> {
	class Node<E>{
		//노드
		private E data;			//데이터
		private Node<E>next;	//뒤쪽 포인터(다음 노드 참조)
		
		//생성자
		Node(E data, Node<E> next){
			this.data=data;
			this.next=next;
		}
	}
	private Node<E> head;	//머리노드
	private Node<E> crnt;	//선택 노드
	//노드 검색
	public E search(E obj, Comparator<? super E> c ) {
		Node<E> ptr=head;					 //현재 스캔 중인 노드
		
		while (ptr!=null) {
			if(c.compare(obj, ptr.data)==0) {//검색성공
				crnt=ptr;
				return ptr.data;
			}
			ptr=ptr.next;					 //다음 노드를 선택
		}
		return null;						 //검색 실패
	}
	//머리에 노드 삽입
	public void addFirst(E obj) {
		Node<E>ptr=head;
		head=crnt=new Node<E>(obj,ptr);
	}
	//꼬리에 노드 삽입
	public void addLast(E obj) {
		if(head==null)
			addFirst(obj);
		else {
			Node<E> ptr=head;
			while (ptr.next!=null)
				ptr=ptr.next;
			ptr.next=crnt=new Node<E>(obj,null);
		}
	}
	//머리 노드를 삭제
	public void removeFirst() {
		if(head!=null)
			head=crnt=head.next;//head.next가 null이기 때문에 결국 head가 null이 되어 삭제와 같은 효과가 일어남.
	}
	//꼬리 노드를 삭제
	public void removeLast() {
		if(head!=null) {
			if(head.next==null)
				removeFirst(); 				//head만 있을경우 실행
			else {
				Node<E>ptr=head;			//스캔중인 노드
				Node<E>pre=head;			//스캔중인 노드의 앞쪽 노드
				while (ptr.next!=null) {	//pre-ptr순으로 위지하게 됨
					pre=ptr;		
					ptr=ptr.next;
				}
				pre.next=null;				//ptr을 null로 만듦(삭제)
				crnt=pre;
			}
		}
	}
	//노드 p를 삭제
	public void remove(Node p) {
		if(head!=null) {
			if(p==head)
				removeFirst();
			else{
				Node<E> ptr=head;
				
				while (ptr.next!=p) {
					ptr=ptr.next;
					if(ptr==null)return; //p가 리스트에 없습니다.
				}
				ptr.next=p.next; //ptr - p - p.next 순이였는데 ptr의 next가 p.next가 되어버려서 삭제의 효과를 가질 수 있음.
				crnt=ptr;
			}
		}
	}
	//선택노드를 삭제
	public void remveCurrentNode() {
		remove(crnt);
	}
	//모든 노드를 삭제
	public void clear() {
		while (head!=null)		
			removeFirst();	//노드에 아무것도 없을때 까지 head노드를 삭제
		crnt=null;
	}
	//선택노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if(crnt==null||crnt.next==null)	//예외처리
			return false;
		crnt=crnt.next;
		return true;
	}
	//선택노드를 출력
	public void printCurrentNode() {
		if(crnt==null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}
	//모든 노드를 출력
	public void dump() {
		Node<E>ptr=head;
		
		while(ptr!=null) {
			System.out.println(ptr.data);
			ptr=ptr.next;
		}
	}
}

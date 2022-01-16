package List;

import java.util.Comparator;

//연결리스트_베열커서
public class AryLinkedList<E> {
	
	//노드
	class Node<E>{
		private E data;
		private int next;
		private int dnext;
		
		//data와 next를 설정
		void set(E data,int next) {
			this.data=data;
			this.next=next;
		}
	}
	private Node<E>[]n;
	private int size;
	private int max;
	private int head;
	private int crnt;
	private int deleted;
	private static final int NULL=-1;
	
	//생성자
	public AryLinkedList(int capacity) {
		head=crnt=max=deleted=NULL;
		try {
			n=new Node[capacity];
			for(int i=0; i<capacity;i++)
				n[i]=new Node<E>();
			size=capacity;		
		}catch (OutOfMemoryError e) {
			size=0;
		}
	}
	
	private int getInsertIndex() {
		if(deleted==NULL) {
			if(max<size)
				return ++max;
			else
				return NULL;
		}else {
			int rec=deleted;
			deleted=n[rec].dnext;
			return rec;
		}
	}
	private void deleteIndex(int idx) {
		if(deleted==NULL) {
			deleted=idx;
			n[idx].dnext=NULL;
		}else {
			int rec = deleted;
			deleted=idx;
			n[idx].dnext=rec;
		}
	}
	public E search(E obj, Comparator<? super E>c) {
		int ptr=head;
		while (ptr!=NULL) {
			if (c.compare(obj, n[ptr].data)==0) {
				crnt=ptr;
				return n[ptr].data;
			}
			ptr=n[ptr].next;
		}
		return null;
	}
	
	public void addFirst(E obj) {
		int ptr=head;
		int rec=getInsertIndex();
		if(rec!=NULL) {
			head=crnt=rec;
			n[head].set(obj, ptr);
		}
	}
	
	public void addLast(E obj) {
		if(head==NULL)
			addFirst(obj);
		else {
			int ptr=head;
			while(n[ptr].next!=NULL)
				ptr=n[ptr].next;
			int rec=getInsertIndex();
			if(rec!=NULL) {
				n[ptr].next=crnt=rec;
				n[rec].set(obj,NULL);
			}
		}
	}
	public void removeFirst() {
		if(head!=NULL) {
			int ptr=n[head].next;
			deleteIndex(head);
			head=crnt=ptr;
		}
	}
	public void removeLast() {
		if(head!=NULL) {
			if(n[head].next==NULL)
				removeFirst();
			else {
				int ptr=head;
				int pre=head;
				
				while(n[ptr].next!=NULL) {
					pre=ptr;
					ptr=n[ptr].next;
				}
				n[pre].next=NULL;
				deleteIndex(ptr);
				crnt=pre;
			}
		}
	}
	
	
	
	
}

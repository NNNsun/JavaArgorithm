package JoAlgorithm;

import java.util.ArrayList;

//노드 구성
class Node<K,V>{
	K key; V value; Node<K,V>next;
	
	
	public Node(K key, V value,Node<K,V>next) {
		this.key=key; this.value=value; this.next=next;
	}
}


//연결리스트를 이용한 순차 검색
//검색: 모든 키를 스캔하면서 입력 키와의 일치 여부 확인
//삽입: 모든 키를 스캔하면서 입력 키와의 일치 여부 확인, 일치하는 키가 없으면 리스트의 제일 앞에 (키,값)의 쌍을 추가
public class SequentialSearchST<K,V> {
	
	//first==잴 앞 pointer
	private Node<K,V>first;
	//전체 node의 수
	int N;
	
	//키를 넣으면 값을 리턴해준다
	public V get(K key) {
		//앞에서부터 순차적으로 진행한다
		for(Node<K,V> x=first; x!=null; x=x.next)
			//같은 것이 있다면 return 해준다
			if(key.equals(x.key))	
				return x.value;		//search 성공
		return null;				//search 실패
	}
	//가장 처음 노드에 키를 입력하는 함수
	public void put(K key, V value) {
		//노드 탐색
		for(Node<K,V>x=first; x!=null; x=x.next)
			if(key.equals(x.key)) { //키가 있을 경우, 값만 변경
				x.value=value;
				return;
			}
		first= new Node<K,V>(key,value,first); //키가 없으면, 앞에 노드 추가
		//전체 노드 수++
		N++;
	}
	//
	public void delete(K key) {
		//first가 key와 같은 경우
		if(key.equals(first.key)) {
			//first의 다음 노드를 first로 지정해준다 ->자연스럽게 first였던 노드는 delete가 된다.
			first=first.next; N--;
			return;
		}
		//first를 제외하고 비교해야하기때문에 x.next를 기준으로 비교한다.
		for(Node<K,V>x=first; x.next!=null;x=x.next) {
			if(key.equals(x.next.key)) {
				//x.next를 delete하기위해 x.next.next로 만들어준다.
				x.next=x.next.next;N--;
				return;
			}
		}
	}
	//Iterable:collection을 추상화로 만들기위해 사용
	//key만 반환
	public Iterable<K>keys(){
		ArrayList<K> keyList =new ArrayList<K>(N);
		for(Node<K,V>x=first; x!=null; x=x.next)
			keyList.add(x.key);
		return keyList;
	}
	
	//포함되어있는지 없는지 확인
	public boolean contains(K key) {return get(key)!=null;}
	//비워져있다면 true
	public boolean isEmpty() {return N==0;}
	//현재 사이즈
	public int size() {return N;}
	
}

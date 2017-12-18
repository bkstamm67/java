package linkedList;

public class BetterSingleLinkedList {
	
	class Node {
		private Node next;
		private int data;
		
		public Node() {
			next = null;
			data = 0;
		}
		
		public Node(int data) {
			this.data = data;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node node) {
			this.next = node;
		}
		
		public int getData() {
			return this.data;
		}
		
		public void setData(int data) {
			this.data = data;
		}
	}
	
	Node head;
	

	public BetterSingleLinkedList(int data) {
		this.head = new Node(data);
	}
	

	
	public void add(int data) {
		Node current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(new Node(data));	
	}
	
	public boolean subtract(int data) {
		boolean answer = false;
		Node current = head;
		Node previous = current;
		
		if(current.getData() != data) {
			current = current.getNext();
			while(current.getData() != data && current.getNext() != null) {
				current = current.getNext();
				previous = previous.getNext();
			}
		}

		if(current.getData() == data) {
			if(previous.equals(current)) {
				head = current.getNext();
			}
			else {
				previous.setNext(current.getNext());
			}
			answer = true;
		}
		
		return answer;
	}
	

}

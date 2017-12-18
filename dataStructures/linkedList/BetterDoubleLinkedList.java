package linkedList;


public class BetterDoubleLinkedList {
	
	class Node {
		private Node next;
		private Node previous;
		private int data;
		
		public Node() {
			next = null;
			previous = null;
			data = 0;
		}
		
		public Node(int data) {
			this.data = data;
			next = null;
			previous = null;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node node) {
			this.next = node;
		}

		public Node getPrevious() {
			return this.previous;
		}
		
		public void setPrevious(Node node) {
			this.previous = node;
		}
		
		public int getData() {
			return this.data;
		}
		
		public void setData(int data) {
			this.data = data;
		}
	}
	
	Node head;
	
	public BetterDoubleLinkedList(int data) {
		head = new Node(data);
	}
	
	public void add(int data) {
		Node current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		
		Node newNode = new Node(data);
		
		current.setNext(newNode);
		newNode.setPrevious(current);
	}

}

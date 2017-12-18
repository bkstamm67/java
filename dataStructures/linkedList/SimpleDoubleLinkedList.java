package linkedList;

public class SimpleDoubleLinkedList {
	
	private SimpleDoubleLinkedList next;
	private SimpleDoubleLinkedList previous;
	private int data;
	
	/**
	 * 
	 */
	public SimpleDoubleLinkedList(){
		this.previous = null;
		this.next = null;
		this.data = 0;
	}
	
	/**
	 * 
	 * @param data
	 */
	public SimpleDoubleLinkedList(int data){
		this.previous = null;
		this.next = null;
		this.data = data;
	}
	
	/**
	 * 
	 * @param data
	 */
	public void setData(int data) {
		this.data = data;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getData() {
		return this.data;
	}
	
	/**
	 * 
	 * @return
	 */
	public SimpleDoubleLinkedList returnPrevious() {
		return this.previous;
	}
	
	/**
	 * 
	 * @param node
	 */
	public void setPrevious(SimpleDoubleLinkedList node) {
		this.previous = node;
	}
	
	/**
	 * 
	 * @return
	 */
	public SimpleDoubleLinkedList returnNext() {
		return this.next;
	}
	
	/**
	 * 
	 * @param node
	 */
	public void setNext(SimpleDoubleLinkedList node) {
		this.next = node;
	}

}

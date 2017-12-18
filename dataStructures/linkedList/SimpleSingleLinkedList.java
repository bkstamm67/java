package linkedList;

/**
 * This is a very basic linked list
 * @author bkstamm67
 */

public class SimpleSingleLinkedList {
	
	private SimpleSingleLinkedList next = null;
	private int data;
	
	/**
	 * 
	 * @param data
	 */
	public SimpleSingleLinkedList(int data) {
		this.data = data;
	}
	
	/**
	 * Setter for data
	 * @param data
	 */
	public void setData(int data) {
		this.data = data;
	}
	
	/**
	 * Returns the stored data
	 * @return data
	 */
	public int getData() {
		return this.data;
	}
	
	/**
	 * Sets the next node
	 * @param node
	 */
	public void setNext(SimpleSingleLinkedList node) {
		this.next = node;
	}
	
	/**
	 * Returns the next node
	 * @return next
	 */
	public SimpleSingleLinkedList getNext() {
		return this.next;
	}
	
	/**
	 * Adds 
	 * @param node
	 */
	public void add(SimpleSingleLinkedList node) {
		this.next = node;
	}
	
}

package tree;

public class BinaryTree {
	
	class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node() {
			left = null;
			right = null;
			this.data = 0;
		}
		
		public Node(int data) {
			left = null;
			right = null;
			this.data = data;
		}
		
		public void setData(int data) {
			this.data = data;
		}
		
		public int returnData() {
			return this.data;
		}
		
		public void setLeft(Node node) {
			this.left = node;
		}
		
		public Node returnLeft() {
			return left;
		}
		
		public void setRight(Node node) {
			this.right = node;
		}
		
		public Node returnRight() {
			return right;
		}
	}
	
	Node root;
	
	public BinaryTree(int data) {
		root = new Node(data);
	}
	
	public void addBranch(int data) {
		Node toAdd = findBranch();
		toAdd.setData(data);
	}
	
	private Node findBranch() {
		Node foundBranch = search(root);
		return foundBranch;
	}
	
	private Node search(Node node) {
		if(node == null) {
			return node;
		}
		if (node.returnLeft() != null){
			return search(node.returnLeft());
		}
		return search(node.returnRight());
		
	}

}

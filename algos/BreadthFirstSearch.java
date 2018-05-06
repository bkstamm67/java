package app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import app.graph.Node;

/**
 * @author Brian Stamm
 *
 */
public class BreadthFirstSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Node> graph = createGraph();
		Node start = graph.get(0);
		int value = 11;
		
		System.out.println("The value of the start node is:  " + start.getValue());
		System.out.println("The value to find:  " + value);
		
		boolean truth = bfs(start, value);
		
		System.out.println("If answer is found:  " + truth);
		

	}
	
	/**
	 * 
	 * @param starter Node to start search from
	 * @param valueToFind int value to find
	 * @return boolean value if the parameter valueToFind was found
	 */
	public static boolean bfs(Node starter, int valueToFind) {
		boolean answer = false;
		
		if(starter.getValue() == valueToFind) {
			answer = true;
		}
		else {
			LinkedList<Node> searchQueue = new LinkedList<Node>();
			searchQueue.add(starter);
			
			while(!searchQueue.isEmpty()) {
				Node current = searchQueue.poll();
				if(!current.hasVisited()) {
					if(current.getValue() == valueToFind) {
						answer = true;
						break;
					}
					current.setVisited(true);
					List<Node> neighbors = current.returnNeighborList();
					for(Node newNode: neighbors) {
						searchQueue.add(newNode);
					}
				}
			}
		}
		
		return answer;
	}
	
	/**
	 * Used to build a simple undirected graph, connected like
	 *     2 - 4 -- 8
	 *   /    /     |
	 * 1    5 - 7 - 9
	 *   \/  \      | 
	 *    3 - 6 -- 10 - 11
	 * @return List of nodes
	 */
	public static List<Node> createGraph(){
		List<Node> graph = new ArrayList<>();
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node ten = new Node(10);
		Node eleven = new Node(11);
		
		one.addNeighbors(two);
		one.addNeighbors(three);
		two.addNeighbors(four);
		two.addNeighbors(one);
		three.addNeighbors(one);
		three.addNeighbors(five);
		three.addNeighbors(six);
		four.addNeighbors(two);
		four.addNeighbors(five);
		four.addNeighbors(eight);
		five.addNeighbors(four);
		five.addNeighbors(three);
		five.addNeighbors(six);
		five.addNeighbors(seven);
		six.addNeighbors(three);
		six.addNeighbors(five);
		six.addNeighbors(ten);
		seven.addNeighbors(five);
		seven.addNeighbors(nine);
		eight.addNeighbors(four);
		eight.addNeighbors(nine);
		nine.addNeighbors(seven);
		nine.addNeighbors(ten);
		ten.addNeighbors(six);
		ten.addNeighbors(nine);
		ten.addNeighbors(eleven);
		eleven.addNeighbors(ten);
		
		graph.add(one);
		graph.add(two);
		graph.add(three);
		graph.add(four);
		graph.add(five);
		graph.add(six);
		graph.add(seven);
		graph.add(eight);
		graph.add(nine);
		graph.add(ten);
		graph.add(eleven);
		
		return graph;
	}
	
}

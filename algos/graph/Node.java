package app.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Brian Stamm
 *
 */
public class Node {

	private int value;
	private List<Node> neighbors;
	private boolean visited;

	public Node(int value){
		this.value = value;
		this.visited = false;
		neighbors = new ArrayList<Node>();
	}

	public void addNeighbors(Node neighbor) {
		neighbors.add(neighbor);
	}
	
	public List<Node> returnNeighborList(){
		return Collections.unmodifiableList(this.neighbors);
	}

	public void removeNeighbor(Node neighbor) {
		neighbors.remove(neighbor);
	}

	public void setVisited(boolean visit) {
		this.visited = visit;
	}

	public boolean hasVisited() {
		return visited;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}

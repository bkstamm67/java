Here are some basic algorithms, along with a basic pseudocode.  All of this information can be found easily throughout the web or a simple algorithm textbook.  I have placed these here for my own personal use and study.

## Table of Contents
- [Breadth First Search](#breadth-first-search)
- [Depth First Search](#depth-first-search)
- [Dijkstra](#dijkstra)

## Graphing
### Breadth First Search
* Info
	* This is used for searching / traversing a graph.  Very close the DFS, with the main difference being BFS looks at each 'level' before moving deeper. 
	* Runtime:  O(V+E)
* Pseudocode
	* breadthFirstSearch(Graph, startVertice)
		* set all vertices to Not Visited
		* Q = empty queue
		* Q.enqueue(startVertice)

		* while (Q is not empty)
			* currentV = Q.dequeue
			* if currentV Not Visited
				* for each neighborV of currentV
					* if (Not Visited)
						* Q.enqueue(neighborV)
* [Wikipedia entry](https://en.wikipedia.org/wiki/Breadth-first_search)

### Depth First Search
* Info
* Pseudocode

### Dijkstra
* Info
* Pseudocode
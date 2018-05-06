Here are some basic algorithms, along with a basic pseudocode.  All of this information can be found easily throughout the web or a simple algorithm textbook.  I have placed these here for my own personal use and study.  There are several resources I have used to create this and have attempted to credit when possible.  None are original.

## Table of Contents
- [Insertion Sort](#insertion-sort)
- [Selection Sort](#selection-sort)
- [Merge Sort](#mergesort)
- [Breadth First Search](#breadth-first-search)
- [Depth First Search](#depth-first-search)
- [Dijkstra](#dijkstra)

## Web Resources
- [Wikipedia](https://en.wikipedia.org/wiki/Main_Page)
- [Geeks for Geeks](https://www.geeksforgeeks.org/)
- [Google](http://www.google.com/)
- [Rosetta Code](http://rosettacode.org/wiki/Rosetta_Code)
- [Big-O Algorithm Complexity Cheatsheet](http://bigocheatsheet.com/)

## Sort
### Insertion Sort
* Intro
	* This is a very basic sorting algorithm
	* Runtime - O(n^2)
* Pseudocode
	* insertionSort(array)
		* for i from 1 to length of array
			* value of array[i]
			* index j is equal to i-1
			* while j is >= 0 and if array[j] > value
				*  
* [Geeks for Geeks entry](https://www.geeksforgeeks.org/insertion-sort/)

### Selection Sort
* Intro
	* This is another very basic sorting algorithm
	* Runtime - O(n^2)
* Pseudocode
* Entry

### MergeSort
* Intro
	* This is a better sorting algorithm that uses a divide and conquer method. It continually divides a list into halves recursively until it gets only one item.  Then it puts those items back together in sorted order.
	* Runtime - O(nlogn)
* Pseudocode
* [Geeks for Geeks entry](https://www.geeksforgeeks.org/merge-sort/)

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
* Intro
* Pseudocode
* [Google](http://www.google.com)

### Dijkstra
* Intro
* Pseudocode
* [Google](http://www.google.com)
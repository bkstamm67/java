Here are some basic algorithms, along with a basic pseudocode.  All of this information can be found easily throughout the web or a simple algorithm textbook.  I have placed these here for my own personal use and study.  There are several resources I have used to create this and have attempted to credit when possible.  None are original.

## Table of Contents
- [Insertion Sort](#insertion-sort)
- [Selection Sort](#selection-sort)
- [Merge Sort](#mergesort)
- [Heap Sort](#heapsort)
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
	* This is a very basic sorting algorithm, than moves elements one at a time into the correct position of the array
	* Runtime - O(n^2)
* [Geeks for Geeks entry](https://www.geeksforgeeks.org/insertion-sort/)

### Selection Sort
* Intro
	* This is another very basic sorting algorithm - finding the smallest element, and places it at the beginning of the array.  It then looks at the remaining elements needing to be sorted, finding the smallest, and places it next to the first element.  It continues until the entire array is sorted.  
	* The benefit to this is that although it is inefficient is that this sorting 
	algorithm moves the least amount of elements, so if writing data is expensive, this is a good option.
	* Runtime - O(n^2)
* [Wikipedia](https://en.wikipedia.org/wiki/Selection_sort)

### MergeSort
* Intro
	* This is a better sorting algorithm that uses a divide and conquer method. It continually divides a list into halves recursively until it gets only one item.  Then it puts those items back together in sorted order.
	* Runtime - O(nlogn)
* [Geeks for Geeks entry](https://www.geeksforgeeks.org/merge-sort/)

### HeapSort
* Intro
	* This sorting algorithm runs through the array, using the properties of a
	max heap to find the largest value, place it at the end of the array, and 
	continue that behavoir until it's sorted.  One benefit of the heap sort is
	it is done in place, so no extra storage is needed.
	* Runtime - O(nlogn)
* Pseudocode
	* heapSort(array,count)
		* heapify(array, count), placing in max-heap order
		* end = count -1
		* while end > 0
			* swap max value with last element
			* put heap back in max-heap order
* [Geeks for Geeks entry](https://www.geeksforgeeks.org/heap-sort/)


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
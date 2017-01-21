/*
Assignment number : 6.2
File Name : ListIterator.java
Name : Ilay Serr
Email : ilay92@gmail.com
*/
package linkedList;

/** Represents an iterator of a linked list. 
 * An iterator is characterized by the node at which it is currently anchored. 
 */
public class ListIterator<T> {
	
	// current position in the list
	Node<T> current;
	
	/** Constructs a list iterator, starting at the given node
	 * 		
	 * @param node  where this listIterator is anchored
	 */
	public ListIterator(Node<T> node) {
		current = node;
	}
	
	/** Checks if this iterator has more nodes to process
	 * 			
	 * @return  true if there are more nodes to process, false otherwise.
	 */
	public boolean hasNext() {
		return (current != null);
	}
				
	/** Returns the next element in the list and advances the cursor position
	 * 
	 * Should be called only if hasNext() is true.
	 * 
	 * @return
	 */
	public T next() {
		Node<T> currentNode = current;
		current = current.next;
		return currentNode.data;
	}
}
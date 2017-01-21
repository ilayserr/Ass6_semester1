/*
Assignment number : 6.3
File Name : LinkedList.java
Name : Ilay Serr
Email : ilay92@gmail.com
*/

package linkedList;

/** Represents a linked list of Node objects. */
public class LinkedList<T> {
	
	// A pointer to this list first.
	private Node<T> first;
	
	// A pointer to the last element in the list
	private Node<T> last;
	
	// Number of elements in this list
	private int size;

	/** 
	 * Constructs an empty list.
	 */
    public LinkedList() {
    	
        first = new Node<T>(null);
        last = first;
        size = 0;
	}
    
    /** Returns the size of this list.
     * 
     * @return the list's size
     */
    public int size() {
        return size;
	}
    
    /**
	 * Returns the node located at the given index in this list. 
	 * 
	 * @param index
	 *        the index of the node to retrieve, between 0 and size
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than the list's size
	 * @return the element at the given index
	 */		
    public T get (int index) {
    	if (index < 0 || index > size) {
    		throw new IllegalArgumentException("index is negative or greater"
    												+ " than the list's size");
    	}	
    	Node<T> curr = first.next;
    	int count = 0;
        while (count != index) {
            curr = curr.next;
            count++;
        }    
        return curr.data;
	}

    /** Inserts the given element at the beginning of this list.
     * 	
     * @param t  the value to insert.
     */
    public void addFirst(T t) {
    	Node<T> newNode = new Node<T>(t);
    	
    	// Inserts the new node between the dummy and the first node.
	    newNode.next = first.next;
	    first.next = newNode;	
	    size++;
	    if (size == 1) last = newNode;
	}

    /** Inserts the given element at the end of this list.
    * 	
    * @param t  the value to insert.
    */
    
    public void addLast(T t) {
    	if (first.next == null) {
    		this.addFirst(t);
    		return;
    	}
    	Node<T> newNode = new Node<T>(t);
    	last.next = newNode;
    	last = newNode;
    	size++;
	}
	
    
    /** Returns the index of the node containing e
     * 
     * @param t   the element that we are searching
     * @return    the index of this element, or -1 is the element is 
     * not in this list
     */
    public int indexOf(T t) {
    	if (size == 0) return -1;
    	Node<T> curr = first.next;
    	int index = 0;
    	while (index < size) {
    		if (curr.data.equals(t)) {
    			return index;
    		} 
    		curr = curr.next;
    		index++;	
    	}
    	return -1; 
    }
    
    /** Removes the first occurance of the given element from this list.
     * 
     * @param t  the element to be removed.
     * @return   true is this list contained the given element, false otherwise.
     */
    public boolean remove (T t) {
    	if (indexOf(t) == -1) return false;
    	
    	// Creates two pointers that follow each other in lock-step.
        Node<T> prev = first;
        Node<T> node = first.next;
        while (node.data != t) { 
        	prev = node;
        	node = node.next;
        }
        if (node.next == (null)) last = prev;
        prev.next = node.next;
        node = null;
        size--;
        return true;
    }
    
    
     /** Inserts the given element at the given position in this list.
      * 
      * @param index  the position where the new element will end up being
      * @param t      the element to insert
      */
    public void add (int index, T t) {
    	if (index < 0 || index > size) {
    		throw new IllegalArgumentException(" index is negative or greater"
    												+ " than the list's size");
    	}	
    	Node<T> curr = first.next;
 		int count = 1;
 		if (index == 0) {
 			addFirst(t);
 			return;
 		}
 		if (index == size) {
 			addLast(t);
 			return;
 		}
        while (count != index) {
            curr = curr.next;
            count++;
        }
        Node<T> newNode = new Node<T>(t, curr.next);
        curr.next = newNode;
        if (index == size) last = newNode;
        size++;
	}
     
     /** Returns an iterator over this list.
      * 
      * @return a ListIterator object anchored at the first element of this list
      */
    public ListIterator<T> listIterator() {
     	return new ListIterator<T>(first.next);
     }	    
    
    /** 
     * Returns a textual representation of this list.
     */
    public String toString() {
    	    StringBuilder s = new StringBuilder();

    	    Node<T> node = first.next;
    	    while (node != null) {
    		    s.append(node.data + " ");
    		    node = node.next;
    	    }
    	    return s.toString();
    }
    
    /** 
     * Prints this list.
     */
    public void print() {    	
    	    for (ListIterator<T> itr = new ListIterator<T>
    	    				(first.next); itr.hasNext(); ) {
    		    System.out.print(itr.next() + " ");
        	}
     	System.out.println();
    }
}
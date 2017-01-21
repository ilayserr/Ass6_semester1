/*
Assignment number : 6.1
File Name : Node.java
Name : Ilay Serr
Email : ilay92@gmail.com
*/

package linkedList;

	/** Represents a node in a linked list. 
	 * A node is characterized by a value (t) and a pointer to another node. 
	 * @author intro2cs@IDC staff
	 */
public class Node<T> {
	T data;       	// package-private visibility
	Node<T> next;      	// package-private visibility 
    
    /**
     * constructs a node with the given data and make him point to null.
     * @param t - the given data
     */
    public Node (T t) {
    	this (t, null);
    }
    
    /**
     * constructs a node with the given data and makes it point to the next node
     * @param t - the given data
     * @param next - the given next node
     */
    public Node (T t, Node<T> next) {
    	this.data = t;
        this.next = next;
    }
    
    /**
     * return the node data
     */
    public String toString () {
    	 return "" + this.data;
    	
    }
}
   
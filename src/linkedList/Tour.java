package linkedList;
/*
Assignment number : 6.5
File Name : Tour.java
Name : Ilay Serr
Email : ilay92@gmail.com
*/

public class Tour {
	
	// A pointer to this list
	private LinkedList<Point> tour;
	
	/**
	 *  Constructs an empty tour.
	 */
	public Tour() {
        tour = new LinkedList<Point>();
	}
	
	/**
	 * draw all the points and points names. and draw the lines between them.
	 */
	public void draw () {
		if (tour.size() == 0) return;
		ListIterator<Point> it =  tour.listIterator();
		Point curr = it.next();
		Point first = curr;
		curr.draw();
		while (it.hasNext()) {
			Point after = it.next();
			after.draw();
			curr.drawTo(after);
			curr = after;
		}
		curr.draw();
		curr.drawTo(first);
	}
	
	/**
	 * prints all the points data. according to their order.
	 */
	public void print () {
		if (tour.size() == 0) System.out.println("NO CITIES");
		ListIterator<Point> it =  tour.listIterator();
		while (it.hasNext()) {
			Point curr = it.next();
			System.out.println(curr);
		}
	}
	
	/**
	 * calculate the total distance.
	 * @return the total distance
	 */
	public double distance () {
		if (tour.size() == 0) return 0.0;
		ListIterator<Point> it =  tour.listIterator();
		Point curr = it.next();
		Point first = curr;
		double sum = 0.0;
		while (it.hasNext()) {
			Point after = it.next();
			sum = sum + curr.distanceTo(after);
			curr = after;
		}
		sum = sum + curr.distanceTo(first);
		return sum;
	}
	
	/**
	 * returns the size of the tour.
	 */
	public int size() {
		return tour.size();
	}
	
	/**
	 * insert the new point p in the best location possible
	 * using the smallest increase heuristic.
	 * @param p - the point to be added
	 */
	public void insertSmallest (Point p) {
		if (size() == 0) {
			tour.addFirst(p);
			return;
		}
		ListIterator<Point> it = tour.listIterator();
		double min = Double.POSITIVE_INFINITY;
		int index = 0;
		int minIndex = 0;
		Point last = tour.get(size() - 1);
		while (it.hasNext()) {
			Point curr = it.next();
			double dis = curr.distanceTo(p) + last.distanceTo(p) 
			 							- last.distanceTo(curr);
			if (dis < min) {
				min = dis;
				minIndex = index;
			} else if (dis == min && minIndex == 0) {
				minIndex = index;
			}
			index++;
			last = curr;
		}
		if (minIndex == 0) minIndex = size();
		tour.add(minIndex, p);	
	}
	
	/**
	 * remove the point that makes the rout longest.
	 * relevant only if the tour size is bigger than 2.
	 */
	public void optimalRemove () {
		if (size() < 2) return;
		ListIterator<Point> it = tour.listIterator();
		double max = 0;
		Point removed = null;
		Point last = tour.get(size() - 1);
		Point preLast = tour.get(size() - 2);
		while (it.hasNext()) {
			Point curr = it.next();
			double dis = preLast.distanceTo(last) + last.distanceTo(curr) 
												- preLast.distanceTo(curr);
			if (dis > max) {
				max = dis;
				removed = last;
			}
			preLast = last;
			last = curr;
		}
		tour.remove(removed);
	}
}
	
	

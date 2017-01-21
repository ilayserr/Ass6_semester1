package linkedList;
/*
Assignment number : 6.4
File Name : Point.java
Name : Ilay Serr
Email : ilay92@gmail.com
*/

public class Point {
	
	private double x;	// the x coordinate 
	private double y;	// the y coordinate 
	private String name; // the name of the city.
	
	 /**
	  * construct a new point.
	  * @param x - the x element
	  * @param y - the y element
	  * @param name - the name of the point
	  */
	public Point (double x, double y, String name) {
		
		this.x = x;
		this.y = y;
		this.name = name;
		
	}
	
	/**
	 * return the x element of the point
	 * @return - the x element
	 */
	public double getXcomponent() {
		return x;
	}

	/**
	 * return the y element of the point
	 * @return - the y element
	 */
	public double getYcomponent() {
		return y;
	}
	
	/**
	 * calculate the distance between two points and returns it
	 * @param other the other point
	 * @return the distance between to points
	 */
	public double distanceTo (Point other) {
		
		double disX = other.getXcomponent() - this.getXcomponent();
		double disY = other.getYcomponent() - this.getYcomponent();
		return Math.hypot(disX, disY);
		
	}
	
	/**
	 * draw the point and from its right the point name.
	 */
	public void draw () {
		
		StdDraw.point(this.x, this.y);
		StdDraw.textRight(this.x, this.y, this.name);
		
	}
	
	/**
	 * draw a line between two points.
	 * @param other - the other point
	 */
	public void drawTo (Point other) {
		
		StdDraw.line(this.x, this.y, other.x, other.y);
		
	}
	
	/**
	 * return the point data as a string.
	 */
	public String toString () {
		return ("(" + this.x + " , " + this.y + ") - " + this.name);
	}

}

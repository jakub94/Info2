package SierpinskiTriangle;
import java.awt.Graphics;
import java.awt.Point;


public class Triangle 
{
	
	
	private Graphics g; 
	private Point A; 
	private Point B; 
	private Point C;
	
	public Triangle(Graphics g, Point A, Point B, Point C)
	{
		this.g = g;
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public Graphics getG() {
		return g;
	}
	public void setG(Graphics g) {
		this.g = g;
	}
	public Point getA() {
		return A;
	}
	public void setA(Point a) {
		A = a;
	}
	public Point getB() {
		return B;
	}
	public void setB(Point b) {
		B = b;
	}
	public Point getC() {
		return C;
	}
	public void setC(Point c) {
		C = c;
	}
}

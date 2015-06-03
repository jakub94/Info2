package SierpinskiTriangle;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class DrawDemo 
{
	public static void main(String[] args)
	{
		SierpinskiTriangle triangle = new SierpinskiTriangle(9);
		triangle.display();
	}
}

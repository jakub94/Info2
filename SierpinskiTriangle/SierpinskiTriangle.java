package SierpinskiTriangle;

import java.awt.BorderLayout;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SierpinskiTriangle 
{
	public static int SIZE = 1000;

	private JFrame frame;
	private JPanel panel;
	private Color[] levelColors;
	private int levels;
	private int level; 
	
	public SierpinskiTriangle(int levels)
	{
		fillColorArray(levels);
		this.levels = levels;
		this.level = levels;

	}

	@SuppressWarnings("serial")
	public void display() 
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() 
		{
			@Override
			public void paint(Graphics g) 
			{
				super.paint(g);
				paintSierpinskiTriangle(g, getSize());
			}
		};
		panel.addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentResized(ComponentEvent e) 
			{
				panel.repaint();
			}
		});
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setSize(SIZE, SIZE);
		frame.setVisible(true);
	}

	public void paintSierpinskiTriangle(Graphics g, Dimension size)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.white);
		g2.clearRect(0, 0, size.width, size.height);
		g2.draw3DRect(20, 20, size.width - 40, size.height - 40, true);

		this.level = levels; 
		startSierpinski(g, size); 
	}

	public void startSierpinski(Graphics g, Dimension size)
	{		
		int h =  size.height -20 ;
		int a = (int)(2*h / Math.sqrt(3));

		if(a > size.width - 40) 
		{
			a = size.width - 40; 

			double gh = (Math.sqrt(3)/2)*a; 
			h = (int) gh; 
		}

		int x = (int)(-0.5 * a);

		int midX = (size.width)/2;

		Point C = new Point(midX, 20);		
		Point A = new Point(midX - x, h);
		Point B = new Point(midX + x, h);

		Triangle t = new Triangle(g, A, B, C);
		drawTriangle(t, getLevelColor(level)); 
		
		level--;
		drawInnerTriangle(t);
		level--;
		

		
		ArrayList<Triangle> triangles = new ArrayList<Triangle>();
		ArrayList<Triangle> trianglesTemp = new ArrayList<Triangle>();
		triangles.addAll(Arrays.asList((drawTriangles(t))));
		
		while(level > 1)
		{
			level--;
			for(int i = 0; i < triangles.size(); i++)
			{
				 trianglesTemp.addAll(Arrays.asList(drawTriangles(triangles.get(i))));
			}
			triangles.clear();
			triangles.addAll(trianglesTemp);
			trianglesTemp.clear();
		}
		
	}

	private void drawInnerTriangle(Triangle triangle)
	{
		Point Mab = findMindpoint(triangle.getA(), triangle.getB());
		Point Mbc = findMindpoint(triangle.getB(), triangle.getC());
		Point Mac = findMindpoint(triangle.getA(), triangle.getC());
		
		Triangle t = new Triangle(triangle.getG(), Mab, Mbc, Mac); 
		
		drawTriangle(t, getLevelColor(level)); 
	}

	private Point findMindpoint(Point p1, Point p2)
	{
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2); 
	}

	private Triangle[] drawTriangles(Triangle t) 
	{
			Graphics g = t.getG();
			Point A = t.getA();
			Point B = t.getB();
			Point C = t.getC();
			
			Point Mab = findMindpoint(A, B);
			Point Mbc = findMindpoint(B, C);
			Point Mac = findMindpoint(A, C);

			Triangle t1 = new Triangle(g, A, Mab, Mac);
			Triangle t2 = new Triangle(g, Mab, B, Mbc);
			Triangle t3 = new Triangle(g, Mac, Mbc, C);
			drawInnerTriangle(t1);
			drawInnerTriangle(t2);
			drawInnerTriangle(t3);
			
			return new Triangle[] {t1, t2, t3};
	}
	

	
	private void drawTriangle(Triangle t, Color c)
	{
		Polygon triangle = new Polygon();
		triangle.addPoint(t.getA().x, t.getA().y);
		triangle.addPoint(t.getB().x, t.getB().y);
		triangle.addPoint(t.getC().x, t.getC().y);
		t.getG().setColor(c);
		t.getG().fillPolygon(triangle);
	}
	


	private Color getRandomColor()
	{
		Random random = new Random();
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)); 
	}
	
	public Color getLevelColor(int level)
	{
		return levelColors[level-1];
	}
	
	private void fillColorArray(int levelCount)
	{
		Color[] colors = new Color[levelCount];
		for(int i = 0; i< levelCount; i++)
			colors[i] = getRandomColor();
		
		this.levelColors = colors;
	}

}

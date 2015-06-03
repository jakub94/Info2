package ProbabilisticAlgorithms.PI_Computation;

import java.awt.geom.Point2D;
import java.util.Random;

public class PICalculator
{  
    public static void main (String[] args)
    {
    	int numberOfPoints = 5000000;
        double PI = PICalculator.calculatePI(numberOfPoints);
        System.out.println ("Number of points = " + numberOfPoints + ", Computed PI = " + PI);     
    }
    
    public static double calculatePI (int numberOfPoints)
    {  
    	Point2D point = null;   
        int hits = 0;      

        for (int i = 0; i < numberOfPoints; i++)
        {  
        	point = getRandomPoint();

            if (isInside(point.getX(), point.getY(), 0.5))
                hits++;
        }
    
        return (4.0 * (hits /(double)numberOfPoints));

    }
    
    private static Point2D getRandomPoint()
    {
    	Random random = new Random();          
        return new Point2D.Double(random.nextDouble(), random.nextDouble());
    }
    private static boolean isInside (double xPos, double yPos, double radius)   
    {   
    	//(Math.sqrt(((xPos- radius) * (xPos - radius)) + ((yPos - radius) * (yPos - radius))) < Math.sqrt((radius * radius)));
    	return (Math.sqrt((xPos * xPos) + (yPos * yPos)) < radius * 2);
    }
}

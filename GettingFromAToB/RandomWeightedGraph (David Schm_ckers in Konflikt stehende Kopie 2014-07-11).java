package GettingFromAToB;

import java.util.ArrayList;
import java.util.Random;

public class RandomWeightedGraph extends WeightedGraph
{
	
	ArrayList<Vertex> connected; 
	Random random;
	
		
	public RandomWeightedGraph(int maxWeight, int vertices, int edges, Vertex root)
	{
		super(root);
		random = new Random();
		int dif = edges - vertices; 
	
		connected = new ArrayList<Vertex>(); 
		connected.add(root); 
		
		Vertex startVertex = root; 
		
		for(int i = 0; i < vertices-1; i++)
		{
			Vertex v = new Vertex("" + (char)(65 + i));
			
			Edge e = new Edge(random.nextInt(maxWeight), getAnyConnectedVertex(), v); 
			
			startVertex.addEdge(e);
			connected.add(v);
			startVertex = getAnyConnectedVertex(); 
		}
		
		for(int j = 0 ; j < dif; j++)
		{
			Vertex tmp = getAnyConnectedVertex(); 
			Edge e = new Edge(random.nextInt(maxWeight), tmp, getAnyConnectedVertex());
			tmp.addEdge(e);
			 
		}

	}
	
	private Vertex getAnyConnectedVertex() 
	{
		int index = random.nextInt(connected.size());
		return connected.get(index);
	}	
}
	

package GettingFromAToB;

import java.util.HashSet;
import java.util.ArrayList; 
import java.util.Random; 

public class WeightedGraph
{
	private Vertex root;
	private HashSet<Vertex> visitedVertices; 
	private int numberOfVertices; 
	private HashSet<Vertex> vertices; 

	public WeightedGraph(Vertex root)
	{
		this.root = root;
		visitedVertices = new HashSet<Vertex>(); 
		vertices = new HashSet(); 
		updateNumberOfVertices(); 
		
	}

	public Vertex getRoot()
	{
		return root;
	}
	
	public int getNumberOfVertices()
	{
		return numberOfVertices;
	}

	private void printGraphSection(Vertex vertex)
	{
		if(visitedVertices.contains(vertex))
			return; 
		visitedVertices.add(vertex);		
		
		if(vertex.getEdges().size() > 0)
		{
			ArrayList<Edge> edges = vertex.getEdges();
			
			for(Edge edge : edges)
			{
				Vertex nextVertex = edge.getEnd();
				System.out.println(vertex.getName() + "---" + edge.getWeight() + "-->" + edge.getEnd().getName());
				
				printGraphSection(nextVertex); 
			}
		}
		//else
			//System.out.println(vertex);
	}
	
	public void print()
	{
		printGraphSection(this.root); 
		visitedVertices.clear();
	}
	
	public Vertex getRandomVertex()
	{
		updateNumberOfVertices();
		
		return getRandomVertex(numberOfVertices); 
	}
	
	private Vertex getRandomVertex(int numberOfVertices)
	{
		Random rand = new Random();
		int n = rand.nextInt(numberOfVertices);
		
		return getAnyVertex(root, n);
	}
	
	private Vertex getAnyVertex(Vertex vertex, int n)
	{
		if(n == 0)
			return vertex; 
		if(vertex.getEdges().size() > 0)
		{
			ArrayList<Edge> edges = vertex.getEdges();
			
			for(Edge edge : edges)
			{
				Vertex nextVertex = edge.getEnd(); 
				return getAnyVertex(nextVertex, n-1);
			}
		}
		return vertex; 
		
	}
	
	private void updateNumberOfVerticesRecursively(Vertex vertex)
	{
		if(visitedVertices.contains(vertex))
			return; 
		visitedVertices.add(vertex);
		
		if(vertex.getEdges().size() > 0)
		{
			ArrayList<Edge> edges = vertex.getEdges();
			
			for(Edge edge : edges)
			{
				Vertex nextVertex = edge.getEnd();
				
				updateNumberOfVerticesRecursively(nextVertex); 
			}
		}
		
	}

	public void updateNumberOfVertices()
	{
		updateNumberOfVerticesRecursively(root);
		this.numberOfVertices = visitedVertices.size();
		visitedVertices.clear();
	}
	
	
	public HashSet<Vertex> getVertices()
	{
		return this.vertices; 
	}
	
	
	public void getAllVertices()
	{
		vertices.clear();
		getAllVertices(root); 
	}
	
	
	private void getAllVertices(Vertex vertex)
	{
		vertices.add(vertex); 
		if(vertex.getEdges().size() > 0)
		{
			ArrayList<Edge> edges = vertex.getEdges();
			
			for(Edge edge : edges)
			{
				Vertex nextVertex = edge.getEnd();
								
				
				getAllVertices(nextVertex); 
				
			}
		}
	}
}

package GettingFromAToB;

import java.util.ArrayList; 
import java.util.Iterator;

public class Vertex
{
	private String name;
	private ArrayList<Edge> edges;
	
	
	public Vertex(String name)
	{
		this.name = name;
		this.edges = new ArrayList<Edge>();
	}

	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ArrayList<Edge> getEdges()
	{
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges)
	{
		this.edges = edges;
	} 
	
	public void addEdge(Edge e)
	{
		edges.add(e); 
	}
	
	
	public void deleteEdge(Edge e)
	{
		Iterator<Edge> it = edges.iterator();
		while(it.hasNext())
		{
			Edge edge = it.next(); 
			if(edge == e)
				it.remove();
		}
	}
	
	public String toString()
	{
		String e = "0";
		if(edges.size() != 0)
			e = "" + edges.size();
		return this.name + " " + e;  
	}
	
	public boolean edgeAlreadyExists(Edge e)
	{
		for(Edge edge : edges)
		{
			if((edge.getEnd().equals(e.getEnd())) && (edge.getStart().equals(e.getStart()))) 
			{
				return true;
			}
		}
		return false; 
	}
}
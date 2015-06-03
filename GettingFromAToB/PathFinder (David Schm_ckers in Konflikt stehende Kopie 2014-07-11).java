package GettingFromAToB;

import java.util.ArrayList;
import java.util.Iterator;

public class PathFinder
{
	private ArrayList<AdjVertex> vertices;
	private WeightedGraph path;

	public PathFinder()
	{
		vertices = new ArrayList<>();
	}
	
	protected class AdjVertex
	{
		public AdjVertex(int value, Vertex current, Vertex predecessor)
		{
			this.value = value;
			this.current = current;
			this.predecessor = predecessor;

			visited = true;
		}
		int value;
		Vertex current;
		Vertex predecessor; 
		boolean visited;
	}

	public WeightedGraph getShortestPath(WeightedGraph graph, Vertex start, Vertex end)
	{
		System.out.println("From " + start + " to " + end);
		stupidWrapperMethod(start);
		String tmp = "";
		for(AdjVertex adj : vertices)
		{
			if(adj.predecessor != null)
				if(adj.current.equals(end))
					tmp =  "steps: " +  adj.value + " predecessor: " + adj.predecessor.getName();
		}
		if(tmp == "")
			tmp = "No path";
		
		System.out.println(tmp);
		
		constructPath(end);
		path = new WeightedGraph(getStart(start));
		return path;
	}
	
	private Vertex getStart(Vertex start)
	{
		for(AdjVertex adj : vertices)
		{
			if(adj.current.getName().equals(start.getName()))
				return adj.current;
		}
		return null;
	}
	
	private void stupidWrapperMethod(Vertex start)
	{
		indexShortestPath(null, start, 0);
	}

	private void indexShortestPath(Vertex predecessor, Vertex current, int value)
	{
		if(isShortestPathSoFar(current, value))
			vertices.add(new AdjVertex(value, current, predecessor));

		for(Edge edge : current.getEdges())
		{
			if(!wasVisited(edge.getEnd(), current))
				indexShortestPath(current, edge.getEnd(), value + 1);
		}
	}

	private boolean isShortestPathSoFar(Vertex vertex, int value)
	{
		for(AdjVertex v : vertices)
		{
			if(v.current.getName().equals(vertex.getName()))
				return value < v.value;
		}
		return true;
	}

	private boolean wasVisited(Vertex current, Vertex predecessor)
	{
		for(AdjVertex v : vertices)
		{
			if(!(predecessor == null))
				if(current.getName().equals(v.current.getName()) && predecessor.getName().equals(predecessor.getName()))
					return true;
		}
		return false;
	}
	
	
	private void constructPath(Vertex end)
	{
		for(AdjVertex v : vertices)
		{
			if(v.current.equals(end))
			{
				if(v.predecessor != null)
				{
					ArrayList<Edge> edges = v.predecessor.getEdges();
					Iterator<Edge> iterator = edges.iterator();
					while(iterator.hasNext())
					{
						Edge edge = iterator.next();
						if(!edge.getEnd().equals(end))
							v.predecessor.deleteEdge(edge);
					}
				}
				constructPath(v.predecessor);
			}
		}
	}
}

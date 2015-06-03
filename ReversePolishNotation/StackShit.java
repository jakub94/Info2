package ReversePolishNotation;
public class StackShit<T> 
{
	private int total;
	private Node first;
	
	class Node
	{
		private T element;
		private Node next;
		
		public Node(T element, Node next)
		{
			this.element = element;
			this.next = next;
		}
	}
	
	public StackShit()
	{
		
	}
	public StackShit<T> push (T newElement)
	{
		first = new Node(newElement, first);
		total++;
		return this;
	}
	
	public T pop() throws Exception
	{
		if(first == null) throw new Exception("No more elements!");
		T element = first.element;
		first = first.next;
		total--;
		
		return element;
	}
	
	public boolean isEmpty()
	{
		return (first == null);
	}
	
}
